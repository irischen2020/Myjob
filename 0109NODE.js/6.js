//99乘法表
var show = function(){
    let str = "<table border=1>";
    for(var i= 1;i < 10; i++)
    {
        str +="<tr>";
        for(var j= 1;j<i+1;j++)
        {
            str +=`<td>${i}X${j}=${i*j}<td>`;
            // document.write(i*j);
        }
        str += "</tr>";
    // document.write("<br>")
    }
    str += "</table>"
    document.write(str);
}
show();

