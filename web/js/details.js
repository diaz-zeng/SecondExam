function submitToSave() {
    $("#detailsForm").prop('action','userView?doWhat=saveUser').submit();
}
$(function () {
    $("[value=null]").val("");
})