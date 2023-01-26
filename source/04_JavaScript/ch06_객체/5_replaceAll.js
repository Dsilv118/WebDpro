// var str = '안녕00방가00좋은아침00좋은하루00'; // 00 -> x 교체 
// console.log('원본 str : ' + str);
// var splitStr = str.split('00');  // ['안녕','방가','좋은아침','좋은하루']
// console.log('분할된 str : ' + splitStr);
// var joinStr = splitStr.join('x');
// console.log('join된 str : ' + joinStr);

function replaceAll(str, oldStr, newStr){
    let splitStr = str.split(oldStr);
    let result = splitStr.join(newStr);
    return result;
    // return str.split(oldStr).join(newStr); 1줄로 압축
}
var replaceStr = replaceAll('안녕 안녕 안녕 안녕 안녕 안녕', ' ', '');
console.log('결과 : ' + replaceStr);