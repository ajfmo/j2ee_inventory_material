/**
 * 
 */
$(document).ready(function() {
    $(function() {
        $('#stock_table').dataTable({
            "bProcessing": true,
            "sAjaxSource": "resources/data/stock_inward.txt",
            "aoColumns": [{
                "mData": "code"
            }, {
                "mData": "name"
            }, {
                "mData": "stock"
            }, {
                "mData": "unit"
            }, {
                "mData": "amount"
            }, {
                "mData": "price"
            }, {
                "mData": "money"
            }],
            "language": {
                "url": "https://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Vietnamese.json"
            }
        });
    });
    
    // provider Name selector
    $("#select_providerN").change(function(){
    	// get value of providerID from providerName
    	var providerID = $(this).find(':selected').data('id').trim();
    	// set providerID for selector.
    	$("select#select_providerID").val(providerID);
    });
    
    // provider ID selector
    $("#select_providerID").change(function(){
    	// get value of providerID from providerName
    	var providerName = $(this).find(':selected').data('value').trim();
    	// set providerID for selector.
    	$("select#select_providerN").val(providerName);
    });
    
    var date = new Date();

    var month = date.getMonth()+1;
    var day = date.getDate();

    var output = date.getFullYear() + '/' +
        ((''+month).length<2 ? '0' : '') + month + '/' +
        ((''+day).length<2 ? '0' : '') + day;
    
    $('#ngayNhap').val(output);
});