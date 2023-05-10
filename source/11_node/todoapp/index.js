const express = require('express'); // express 라이브러리 첨부
const app = express(); // express 라이브러리를 이용하여 객체
const MongoClient = require('mongodb').MongoClient;
const uri = "mongodb+srv://qoxmfspt43:<보지마>@cluster0.jh1ynad.mongodb.net/?retryWrites=true&w=majority";
var db;
MongoClient.connect(uri, function(err, client){
    // MongoDB 연결 후 할 일
    if(err) {return console.log(err);}
    db = client.db("toDoApp");
    app.listen(8090, function(){
        console.log('on 8090');
    });
});

// '/pet' 요청경로(post, get, put, delete)가 들어왔을 때 브라우저 화면에 출력할 태그
app.get('/pet', function(req, res){
    res.send('<h2>펫 용품 쇼핑 페이지입니다.</h2>');
});

// '/' 요청 경로(get)가 들어왔을 때, 브라우저 화면에 출력 html
app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.html');
});

app.use(express.static('public')); // css, js 등의 static 파일은 public 폴더

// '/write' 요청경로(get)가 들어왔을 때 write.html로 가라
app.get('/write', (req, res) => {
    res.sendFile(__dirname + '/write.html');
});

// '/write' 요청경로(post)가 들어왔을 때, 파라미터 정보(title, date)를 DB에 저장
app.use(express.urlencoded({extended : true})); // post 방식으로 들어온 req의 파라미터
app.post('/write', (req, res) => {
    // 1. counter 컬렉션에 현재 시퀀스 값(post_sq)을 가져옴
    db.collection('counter').findOne({name : '현재시퀀스'}, function(err, result){
        // console.log(result);
        var post_sq = result.post_sq;
        // 2. {_id : 현재시퀀스 + 1, title : req.body.title, date : req.body.date}를 post에 insert
        db.collection('post').insertOne({_id : post_sq+1, title : req.body.title, date : req.body.date}, function(err, result){
            if(err) {return console.log(err);}
            // 3. counter의 post_sq 값을 1 증가시킨다.
                // updateOne({수정 할 조건}, {$set : {수정 할 내용}}, function(err, result){});
                // updateOne({수정 할 조건}, {$inc : {증분 할 내용}}, function(err, result){});
            db.collection('counter').updateOne({name : '현재시퀀스'}, {$inc : {post_sq : 1}}, function(err, result){
                // 4. 1~3까지 err 없으면 write.html로 가기
                if(err) {return console.log(err);} 
                res.sendFile(__dirname + "/write.html")
            });
        });
    });
});

// '/list' 요청(get)으로 들어오면 post find한 결과를 배열로 받아 브라우저 화면에 출력
app.set('view enging', "ejs"); // view 엔진으로 ejs를 등록
app.get('/list', (req, res)=>{
    db.collection('post').find().toArray(function(err, result){
        console.log(result); // find한 결과
        res.render("list.ejs", {posts : result}); // == model.addAttribute("post", result);
        
    });
});

app.delete('/delete', (req, res) => {
    // req.body._id번 게시물을 post에서 삭제하고 alert 메세지 전송
    var _id = req.body._id;
    db.collection('post').deleteOne({_id : Number(_id)}, function(err, result){
        if(err) {return console.log(err);}
        res.status(200).send({msg : _id + '번 post 삭제 완료'});
    });
});