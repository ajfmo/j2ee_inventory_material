/**
 * 
 */
$(document).ready(function() {
    $(function() {
        $('#stock_table').dataTable({
            "bProcessing": true,
            "sAjaxSource": "/getProduct",
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
            },
            "footerCallback": function ( row, data, start, end, display ) {
                var api = this.api(), data;
     
                // Remove the formatting to get integer data for summation
                var intVal = function ( i ) {
                    return typeof i === 'string' ?
                        i.replace(/[\$,]/g, '')*1 :
                        typeof i === 'number' ?
                            i : 0;
                };
     
                // Total over all pages
                total = api
                    .column( 4 )
                    .data()
                    .reduce( function (a, b) {
                        return intVal(a) + intVal(b);
                    } );
     
                // Total over this page
                pageTotal = api
                    .column( 4, { page: 'current'} )
                    .data()
                    .reduce( function (a, b) {
                        return intVal(a) + intVal(b);
                    }, 0 );
     
                // Update footer
                $( api.column( 4 ).footer() ).html(
                    '$'+pageTotal +' ( $'+ total +' total)'
                );
            }
        });
    // DataTable

//    	$("#sumAmount").val(table.column( 4 ).data().sum());
    
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
});