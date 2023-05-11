const express = require("express"); // express 라이브러리 첨부
const MongoClient = require("mongodb/lib/mongo_client");
const app = express(); // express라이브러리를 이용, 객체 생성

const mongoClient = require("mongodb").mongoClient;

const uri =
  "mongodb+srv://hyeeeerinnnn:S1p3lyWTH27lFLLm@cluster0.uby6zay.mongodb.net/?retryWrites=true&w=majority";

var db;

MongoClient.connect(uri, function (err, client) {
  // MongoDB 연결 후 할 일
  if (err) {
    return console.log(err);
  }
  db = client.db("todoApp");
  // 임의로 post에 데이터 삽입
  // db.collection("post").insertOne(
  //   { 이름: "김길동", 나이: 28 },
  //   function (err, result) {
  //     if (err) {
  //       return console.log(err);
  //     }
  //   }
  // );

  app.listen(8090, function () {
    console.log("listening on 8090");
  });
});

// app.listen(8090, function () {
//   console.log("listening on 8090");
// });

// '/pet'요청경로(post, get, put, delete)가 들어왔을 때 브라우저 화면에 출력할 태그
app.get("/pet", function (req, res) {
  res.send("<h2>펫 용품 쇼핑 페이지입니다</h2>");
});

// '/'요청경로(GET)가 들어왔을 때, 브라우저 화면에 출력할 html
app.get("/", (req, res) => {
  res.sendFile(__dirname + "/index.html");
});

app.use(express.static("public")); // css, js 등의 static 파일은 public 폴더

// '/write' 요청경로(GET)가 들어왔을 때 write.html로
app.get("/write", (req, res) => {
  // res.sendFile(__dirname + "/write.html");
  res.render("write.ejs");
});

// '/write' 요청경로(POST)가 들어왔을 때 파라미터 정보(title, date)를 DB에 저장

app.use(express.urlencoded({ extended: true })); // POST 방식으로 들어온 req의 파라미터 사용

app.post("/write", (req, res) => {
  // 1. counter 컬렉션에 현재 시퀀스 값(post_seq)을 가져온다
  db.collection("counter").findOne(
    { name: "현재시퀀스" },
    function (err, result) {
      if (err) {
        return console.log(err);
      }
      var post_seq = result.post_seq;

      // 2. {_id: 시퀀스+1, title: req.body.title, date:req.body.date}를 post에 insert
      db.collection("post").insertOne(
        { _id: post_seq + 1, title: req.body.title, date: req.body.date },
        function (err, result) {
          if (err) {
            return console.log(err);
          }
          // 3. counter의 post_seq 값을 1증가
          // updateOne({수정할 조건}, {$set: {수정할 내용}}, function(err, result){});
          // updateOne({수정할 조건}, {$inc: {증분할 내용}}, function(err, result){});
          db.collection("counter").updateOne(
            { name: "현재시퀀스" },
            { $inc: { post_seq: 1 } },
            function (err, result) {
              if (err) {
                return console.log(err);
              }
              // 1~3까지 err 없으면 write.html로 가기
              res.sendFile(__dirname + "/list.html");
            }
          );
        }
      );
    }
  );
});

// '/list' 요청(get)이 들어오면 post find한 결과를 배열로 받아 브라우저 화면에 출력
app.set("view engine", "ejs"); // view 엔진으로 ejs를 등록
app.get("/list", (req, res) => {
  db.collection("post")
    .find()
    .toArray(function (err, result) {
      // console.log(result); // find 한 결과
      res.render("list.ejs", { posts: result });
      // model.addAttribute("post", result);
    });
});

app.delete("/delete", (req, res) => {
  // req.body._id번 게시물을 post에서 삭제하고 alert 메세지 전송
  var _id = req.body._id;
  db.collection("post").deleteOne({ _id: Number(_id) }, function (err, result) {
    if (err) {
      return console.log(err);
    }
    res.status(200).send({
      msg: _id + "번 post 삭제 완료",
    });
  });
});

app.get("/detail/:id", function (req, res) {
  // REST API 방식으로 파라미터 전달
  db.collection("post").findOne(
    { _id: parseInt(req.params.id) },
    function (err, result) {
      if (err) {
        return console.log(err);
      }
      // console.log(result);
      res.render("detail.ejs", { post: result });
    }
  );
});

app.get("/update/:id", function (req, res) {
  // REST API 방식으로 파라미터 전달
  db.collection("post").findOne(
    { _id: parseInt(req.params.id) },
    function (err, result) {
      if (err) {
        return console.log(err);
      }
      console.log(result);
      res.render("update.ejs", { post: result });
    }
  );
});

app.post("/update", function (req, res) {
    console.log(req.body);
    db.collection("post").updateOne(
      { _id: Number(req.body._id) },
      { $set: { title: req.body.title, date: req.body.date } },
      function (err, result) {
        if (err) {
          return console.log(err);
        }
        console.log("수정 완료");
        res.redirect("/detail/" + req.body._id);
        }
    )}
)

app.put("/update", function (req, res) {
    console.log(req.body);
    db.collection("post").updateOne(
      { _id: Number(req.body._id) },
      { $set: { title: req.body.title, date: req.body.date } },
      function (err, result) {
        if (err) {
          return console.log(err);
        }
        console.log("수정 완료");
        res.redirect("/detail/" + req.body._id);
        }
    )}
)