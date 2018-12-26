$(function () {
    $("#selectAll").onclick(function () {
        if(this.checked){
            $("[name=id]:checkbox").prop("checked",true);
        }else{
            $("[name=id]:checkbox").prop("checked",true);
        }
    })
    $("#indexForm").onsubmit(function () {

    })
})