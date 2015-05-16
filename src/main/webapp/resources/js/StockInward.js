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
});