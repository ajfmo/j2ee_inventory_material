﻿function generatedata(rowscount, hasNullValues) {
    // prepare the data
    var data = new Array();
//    if (rowscount == undefined) rowscount = 100;
//    var firstNames =
//    [
//        "Andrew", "Nancy", "Shelley", "Regina", "Yoshi", "Antoni", "Mayumi", "Ian", "Peter", "Lars", "Petra", "Martin", "Sven", "Elio", "Beate", "Cheryl", "Michael", "Guylene"
//    ];
//
//    var lastNames =
//    [
//        "Fuller", "Davolio", "Burke", "Murphy", "Nagase", "Saavedra", "Ohno", "Devling", "Wilson", "Peterson", "Winkler", "Bein", "Petersen", "Rossi", "Vileid", "Saylor", "Bjorn", "Nodier"
//    ];
//
//    var productNames =
//    [
//        "Black Tea", "Green Tea", "Caffe Espresso", "Doubleshot Espresso", "Caffe Latte", "White Chocolate Mocha", "Caramel Latte", "Caffe Americano", "Cappuccino", "Espresso Truffle", "Espresso con Panna", "Peppermint Mocha Twist"
//    ];
//
//    var priceValues =
//    [
//         "2.25", "1.5", "3.0", "3.3", "4.5", "3.6", "3.8", "2.5", "5.0", "1.75", "3.25", "4.0"
//    ];
//
//    for (var i = 0; i < rowscount; i++) {
//        var row = {};
//        var productindex = Math.floor(Math.random() * productNames.length);
//        var price = parseFloat(priceValues[productindex]);
//        var quantity = 1 + Math.round(Math.random() * 10);
//
//        row["id"] = i;
//        row["available"] = productindex % 2 == 0;
//        if (hasNullValues == true) {
//            if (productindex % 2 != 0) {
//                var random = Math.floor(Math.random() * rowscount);
//                row["available"] = i % random == 0 ? null : false;
//            }
//        }
//        row["firstname"] = firstNames[Math.floor(Math.random() * firstNames.length)];
//        row["lastname"] = lastNames[Math.floor(Math.random() * lastNames.length)];
//        row["name"] = row["firstname"] + " " + row["lastname"]; 
//        row["productname"] = productNames[productindex];
//        row["price"] = price;
//        row["quantity"] = quantity;
//        row["total"] = price * quantity;
//
//        var date = new Date();
//        date.setFullYear(2015, Math.floor(Math.random() * 12), Math.floor(Math.random() * 27));
//        date.setHours(0, 0, 0, 0);
//        row["date"] = date;
//       
//        data[i] = row;
//    }
    data = [
    		 { "firstname": "1", "lastname": "name1" , "productname": "pro1", "available": "true", 
    			 "date": "11/24/2015", "quantity": "11", "price": "12"},
    		 { "firstname": "2", "lastname": "name2" , "productname": "pro2", "available": "true", 
    			 "date": "11/24/2015", "quantity": "11", "price": "12"},
    		 { "firstname": "4", "lastname": "name3" , "productname": "pro3", "available": "false", 
    			 "date": "11/24/2015", "quantity": "11", "price": "12"},
    ];
    return data;
}