$(function () {
    $("#selectAll").click(function () {
        if (this.checked) {
            $("[name=id]:checkbox").prop("checked", true);
        } else {
            $("[name=id]:checkbox").prop("checked", false);
        }
    });
})

function update(id) {
    window.location.href=("/userView?doWhat=getDetails&id="+id);
}

function onFormSubmit() {
    // if($("#indexForm").serializeArray().length>0){
    //
    // }
    var checkedID = [];
    $("[name='id']:checkbox").each(function (i) {
        if(this.checked==true){
            checkedID[i] = this.value;
        }
    })
    if(checkedID.length>0){
        $.ajax({
            type: "POST",
            url: "/userAction?action=removeUser",
            async: true,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: $("#indexForm").serialize(),
            dataType:'text',
            success: function (data) {
                console.log(data);
                alert(data);
                $("tr:has([name='id']:checked)").remove();
            },
            error: function () {
                alert("操作失败");
            }
        })
    }else {
        alert("请最少选择一个用户");
    }

}