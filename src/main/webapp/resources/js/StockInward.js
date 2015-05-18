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
    
    //QuanTA -- Add girdview
    // prepare the data
    var data = generatedata(200);
    var source =
    {
        localdata: data,
        datatype: "array",
        updaterow: function (rowid, rowdata, commit) {
            // synchronize with the server - send update command
            // call commit with parameter true if the synchronization with the server is successful 
            // and with parameter false if the synchronization failder.
            commit(true);
        },
        datafields:
        [
            { name: 'firstname', type: 'string' },
            { name: 'lastname', type: 'string' },
            { name: 'productname', type: 'string' },
            { name: 'available', type: 'bool' },
            { name: 'quantity', type: 'number' },
            { name: 'price', type: 'number' },
            { name: 'date', type: 'date' }
        ]
    };
    var dataAdapter = new $.jqx.dataAdapter(source);
    // initialize jqxGrid
    $("#jqxgrid").jqxGrid(
    {
    	theme: "bootstrap",
        width: '100%',
        source: dataAdapter,
        editable: true,
        pageable: true,
        autoheight: true,
        sortable: true,
        altrows: true,
        enabletooltips: true,
        selectionmode: 'singlerow',
        editmode: 'selectedrow',
        columns: [
          { text: 'First Name', columntype: 'textbox', datafield: 'firstname', width: '15%' },
          { text: 'Last Name', datafield: 'lastname', columntype: 'textbox', width: '14%' },
          { text: 'Product', columntype: 'dropdownlist', datafield: 'productname', width: '14%' },
          { text: 'Available', datafield: 'available', cellsalign: 'center', columntype: 'checkbox', width: '14%' },
          {
              text: 'Ship Date', datafield: 'date', columntype: 'datetimeinput', width: '14%', align: 'right', cellsalign: 'right', cellsformat: 'd',
          validation: function (cell, value) {
                  if (value == "")
                     return true;
                  var year = value.getFullYear();
                  if (year >= 2016) {
                      return { result: false, message: "Ship Date should be before 1/1/2016" };
                  }
                  return true;
              }
          },
          {
              text: 'Quantity', datafield: 'quantity', width: '14%', align: 'right', cellsalign: 'right', columntype: 'numberinput',
              validation: function (cell, value) {
                  if (value < 0 || value > 150) {
                      return { result: false, message: "Quantity should be in the 0-150 interval" };
                  }
                  return true;
              },
              createeditor: function (row, cellvalue, editor) {
                  editor.jqxNumberInput({ decimalDigits: 0, digits: 3 });
              }
          },
          { text: 'Price', datafield: 'price', width: '12%', align: 'right', cellsalign: 'right', cellsformat: 'c2', columntype: 'numberinput',
              validation: function (cell, value) {
                  if (value < 0 || value > 15) {
                      return { result: false, message: "Price should be in the 0-15 interval" };
                  }
                  return true;
              },
              createeditor: function (row, cellvalue, editor) {
                  editor.jqxNumberInput({ digits: 3 });
              }
          }
        ]
    });
    // events
    var rowValues = "";
    $("#jqxgrid").on('cellbeginedit', function (event) {
        var args = event.args;
        if (args.datafield === "firstname") {
            rowValues = "";
        }
        rowValues += args.value.toString() + "    ";
        if (args.datafield === "price") {
            $("#cellbegineditevent").text("Begin Row Edit: " + (1 + args.rowindex) + ", Data: " + rowValues);
        }
    });
    $("#jqxgrid").on('cellendedit', function (event) {
        var args = event.args;
        if (args.datafield === "firstname") {
            rowValues = "";
        }
        rowValues += args.value.toString() + "    ";
        if (args.datafield === "price") {
            $("#cellbegineditevent").text("End Row Edit: " + (1 + args.rowindex) + ", Data: " + rowValues);
        }
    });
    
   // var themeSetting= { theme: "bootstrap" };
   // $("#jqxgrid").jqxGrid(themeSetting);
    // set jQWidgets Theme to "Bootstrap"
    //$.jqx.theme = "bootstrap";
    });

});
