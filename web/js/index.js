$(function () {
    $("#selectAll").onclick(function () {
        if (this.checked) {
            $("[name=id]:checkbox").prop("checked", true);
        } else {
            $("[name=id]:checkbox").prop("checked", true);
        }
    })
})

function onFormSubmit() {
    // if($("#indexForm").serializeArray().length>0){
    //
    // }
    var checkedID = [];
    $("[name=id]:checkbox").each(function (i) {
        if(this.checked){
            checkedID[i] = this.val;
        }
    })
    if(checkedID.length>0){
        $.ajax({
            type: "POST",
            dataType: "text",
            url: "/userAction?action=removeUser",
            async: true,
            data: {id:checkedID},
            success: function (result) {
                alert(result.responseText);
            },
            error: function () {
                alert("操作失败");
            }
        })
    }else {
        alert("请最少选择一个用户");
    }

}