document.getElementById("btn").onclick = dianming;
var flag = true;
function dianming(e){
    // console.info(111);
    var text = e.target.innerText;
    if(text == "点名")
    {
        flag = true;
        e.target.innerText = "停止";
    }
    else{
        flag = false;
        e.target.innerText = "点名";
    }
    console.log(text);
    var arr = ['A','B','C','D','E'];
    var index = 0;
    if(flag){
    t = setInterval(() => {
        index = Math.floor(Math.random()*arr.length);
        console.info(arr[index]);
    }, 100);
}else{
    clearInterval(t);
}
}