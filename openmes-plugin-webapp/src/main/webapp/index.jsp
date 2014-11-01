<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<!-- Common CSS File -->
<link rel="stylesheet" type="text/css" href="lib/css/w2ui.css" />
<!-- Common JS File -->
<script src="lib/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="lib/js//w2ui.js"></script>
</head>
<body>
<div id="grid" style="width: 100%; height: 250px;"></div>
</body>
<script>
$(function () {
    $('#grid').w2grid({
        name: 'grid',
        header: 'List of Names',
        columns: [
            { field: 'fname', caption: 'First Name', size: '30%' },
            { field: 'lname', caption: 'Last Name', size: '30%' },
            { field: 'email', caption: 'Email', size: '40%' },
            { field: 'sdate', caption: 'Start Date', size: '120px' }
        ],
        records: [
            { recid: 1, fname: "Peter", lname: "Jeremia", email: 'peter@mail.com', sdate: '2/1/2010' },
            { recid: 2, fname: "Bruce", lname: "Wilkerson", email: 'bruce@mail.com', sdate: '6/1/2010' },
            { recid: 3, fname: "John", lname: "McAlister", email: 'john@mail.com', sdate: '1/16/2010' },
            { recid: 4, fname: "Ravi", lname: "Zacharies", email: 'ravi@mail.com', sdate: '3/13/2007' },
            { recid: 5, fname: "William", lname: "Dembski", email: 'will@mail.com', sdate: '9/30/2011' },
            { recid: 6, fname: "David", lname: "Peterson", email: 'david@mail.com', sdate: '4/5/2010' }
        ]
    });
});
</script>
</html>