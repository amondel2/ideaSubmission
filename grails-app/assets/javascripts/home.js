
$.ajax({
    url: window.fmBaseDir + 'getMyIdeas',
    method: "GET",
    cache: false
}).done(function (data) {
    if (data && data.msg) {
        processdate($("#myIdeas"),data.msg,['title','votes']);

    } else {
        alert(data[1]);
    }
});

$.ajax({
    url: window.fmBaseDir + 'getLatestIdeas',
    method: "GET",
    cache: false
}).done(function (data) {
    if (data && data.msg) {
        processdate($("#newIdeas"),data.msg,['title','votes','creaated']);
    } else {
        alert(data[1]);
    }
});


function processdate(elm,msg,cols) {
    if(msg.error) {
        elm.html(msg.error)
    } else {
        var id="tbl_" + elm.attr('id');
        var tbl = '<table id="' +id +'"  class="table table-bordered table-striped"><thead class="thead-light">';
        $.each(cols,function(ind,val){
           tbl += '<th data-sortable="true">'+ val + '</th>';
        });
        tbl +='</thead><tbody>';
        $.each(msg,function(index,value){
            tbl += "<tr>";
            $.each(cols,function(ind,val){
                tbl += '<td>' + value[val] + '</td>';
            });
            tbl += "</tr>";

        });
        tbl += "</tbody></table>";
    }
    elm.html(tbl)

    $("#" + id).tablesorter({
        theme : "bootstrap",

        widthFixed: true,
        widgetOptions : {
            // using the default zebra striping class name, so it actually isn't included in the theme variable above
            // this is ONLY needed for bootstrap theming if you are using the filter widget, because rows are hidden
            zebra : ["even", "odd"],

            // class names added to columns when sorted
            columns: [ "primary", "secondary", "tertiary" ],

            // reset filters button
            filter_reset : ".reset",

            // extra css class name (string or array) added to the filter element (input or select)
            filter_cssFilter: [
                'form-control',
                'form-control',
                'form-control custom-select', // select needs custom class names :(
                'form-control',
                'form-control',
                'form-control',
                'form-control'
            ]
        }

    });
}