/**
 * Created by quangphuong on 9/19/16.
 */
'use strict';

angular.module('newApp')
    .controller('staffCtrl', ['$scope', '$http', function ($scope, $http) {
        var columns = ["staffId", "staffName", 'staffAddress', 'phone', 'email'];
        $scope.$on('$viewContentLoaded', function () {

            function editableTable() {

                function restoreRow(oTable, nRow) {
                    var aData = oTable.fnGetData(nRow);
                    var jqTds = $('>td', nRow);

                    for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                        oTable.fnUpdate(aData[i], nRow, i, false);
                    }
                    oTable.fnDraw();
                }

                function editRow(oTable, nRow) {
                    var aData = oTable.fnGetData(nRow);
                    nEditing = nRow;
                    var jqTds = $('>td', nRow);
                    for(var i = 0; i < jqTds.length - 1; i++) {
                        jqTds[i].innerHTML = '<input type="text" class="form-control small" value="' + aData[columns[i]] + '">';
                    }
                    jqTds[jqTds.length - 1].innerHTML = '<div class="text-right"><a class="edit btn btn-sm btn-success" href="javascript:;">Save</a> <a class="cancel btn btn-sm btn-default" href="javascript:;"><i class="icons-office-52"></i></a></div>';
                }

                function addRow(oTable, nRow) {
                    var jqInputs = $('input', nRow);
                    for(var i = 0; i < jqInputs.length; i++) {
                        var cell = nRow.cells[i];
                        cell.innerHTML = jqInputs[i].value;
                    }
                    var cell = nRow.cells[nRow.cells.length - 1];
                    cell.innerHTML = '<a class="edit btn btn-sm btn-default" href="javascript:;"><i class="icon-note"></i></a>  <a class="delete btn btn-sm btn-danger" href="javascript:;"><i class="icons-office-52"></i></a>';
                }

                function saveRow(oTable, nRow) {
                    var jqInputs = $('input', nRow);
                    for(var i = 0; i < jqInputs.length; i++) {
                        oTable.fnUpdate(jqInputs[i].value, nRow, i, false);
                    }
                    oTable.fnUpdate('<a class="edit btn btn-sm btn-default" href="javascript:;"><i class="icon-note"></i></a>  <a class="delete btn btn-sm btn-danger" href="javascript:;"><i class="icons-office-52"></i></a>',
                        nRow, jqInputs.length, false);
                    oTable.fnDraw();
                }

                function cancelEditRow(oTable, nRow) {
                    var jqInputs = $('>td', nRow);
                    for(var i = 0; i < jqInputs.length - 1; i++) {
                        oTable.fnUpdate(jqInputs[i].value, nRow, i, false);
                    }
                    oTable.fnUpdate('<a class="edit btn btn-sm btn-default" href="javascript:;"><i class="icon-note"></i></a>  <a class="delete btn btn-sm btn-danger" href="javascript:;"><i class="icons-office-52"></i></a>',
                        nRow, jqInputs.length - 1, false);
                    oTable.fnDraw();
                }

                var oTable = $('#table-staff').dataTable({
                    "bDestroy": true,
                    "scrollX": true,
                    "aLengthMenu": [
                        [10, 15, 20, -1],
                        [10, 15, 20, "All"] // change per page values here
                    ],
                    "sDom": "<'row'<'col-md-6 filter-left'l><'col-md-6'T>r>t<'row'<'col-md-6'i><'col-md-6'p>>",
                    "ajax" : {
                        "url": "./getStaff",
                        "dataSrc": ""
                    },
                    "columns": [
                        { "data": "staffId" },
                        { "data": "staffName" },
                        { "data": "staffAddress" },
                        { "data": "phone" },
                        { "data": "email" },
                        { "data": "" },
                    ],
                    "columnDefs": [ {
                        "targets": -1,
                        "data": null,
                        "defaultContent": '<a class="edit btn btn-sm btn-default" href="javascript:;"><i class="icon-note"></i></a>  <a class="delete btn btn-sm btn-danger" href="javascript:;"><i class="icons-office-52"></i></a>'
                    }],
                    "oTableTools": {
                        "sSwfPath": "global/plugins/datatables/swf/copy_csv_xls_pdf.swf",
                        "aButtons": [
                            {
                                "sExtends": "pdf",
                                "mColumns": [0, 1, 2, 3],
                                "sPdfOrientation": "landscape"
                            },
                            {
                                "sExtends": "print",
                                "mColumns": [0, 1, 2, 3],
                                "sPdfOrientation": "landscape"
                            }, {
                                "sExtends": "xls",
                                "mColumns": [0, 1, 2, 3],
                                "sPdfOrientation": "landscape"
                            }, {
                                "sExtends": "csv",
                                "mColumns": [0, 1, 2, 3],
                                "sPdfOrientation": "landscape"
                            }
                        ]
                    }
                });

                jQuery('#table-edit_wrapper .dataTables_filter input').addClass("form-control medium"); // modify table search input
                jQuery('#table-edit_wrapper .dataTables_length select').addClass("form-control xsmall"); // modify table per page dropdown

                var nEditing = null;

                $('#staff-edit_new').click(function (e) {
                    e.preventDefault();
                    // var aiNew = oTable.fnAddData(['', '',
                    //     '<p class="text-center"><a class="edit btn btn-dark" href=""><i class="fa fa-pencil-square-o"></i>Edit</a> <a class="delete btn btn-danger" href=""><i class="fa fa-times-circle"></i> Remove</a></p>'
                    // ]);
                    // var nRow = oTable.fnGetNodes(aiNew[0]);

                    var rows = oTable.fnGetNodes();
                    // var data = oTable.fnGetData(row);
                    // var jqTds = $('>td', nRow);
                    var nRow = rows[0];
                    var newRow = $(nRow).clone().insertAfter(rows[rows.length - 1]);
                    newRow = newRow[0];
                    for(var i = 0; i < newRow.cells.length - 1; i++) {
                        var cell = newRow.cells[i];
                        cell.innerHTML = '<input type="text" class="form-control small" value="">';
                    }
                    var cell = newRow.cells[newRow.cells.length - 1];
                    cell.innerHTML = '<div class="text-right"><a class="add btn btn-sm btn-success" href="javascript:;">Save</a> <a class="delete btn btn-sm btn-default" href="javascript:;"><i class="icons-office-52"></i></a></div>';
                    // editRow(oTable, newRow);

                    nEditing = nRow;
                });

                $('#table-staff a.add').live('click', function (e) {
                    var nRow = $(this).parents('tr')[0];
                    nEditing = nRow;
                    var jqInputs = $('input', nRow);
                    var updatedValues = {};
                    for(var i = 0; i < columns.length; i++) {
                        updatedValues[columns[i]] = jqInputs[i].value;
                    }
                    console.log(updatedValues);
                    $http({
                        method: 'POST',
                        url: './addStaff',
                        data: $.param(updatedValues),
                        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                    }).success(function (data, status, headers, config) {
                        addRow(oTable, nEditing);
                        nEditing = null;
                    });
                });

                $('#table-staff a.delete').live('click', function (e) {
                    e.preventDefault();

                    var nRow = $(this).parents('tr')[0];

                    // alert("Deleted! Do not forget to do some ajax to sync with backend :)");
                    var aData = oTable.fnGetData(nRow);
                    if(aData !== null) {
                        if (confirm("Are you sure to delete this row ?") == false) {
                            return;
                        }
                        $http({
                            method: 'POST',
                            url: './deleteStaff',
                            data: $.param({
                                id: aData[columns[0]]
                            }),
                            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                        }).success(function (data, status, headers, config) {
                            oTable.fnDeleteRow(nRow);
                        });
                    } else {
                        oTable.fnDeleteRow(nRow);
                    }
                });

                $('#table-staff a.cancel').live('click', function (e) {
                    e.preventDefault();
                    if ($(this).attr("data-mode") == "new") {
                        var nRow = $(this).parents('tr')[0];
                        oTable.fnDeleteRow(nRow);
                    } else {
                        cancelEditRow(oTable, nEditing);
                        nEditing = null;
                    }
                });

                $('#table-staff a.edit').live('click', function (e) {
                    e.preventDefault();
                    /* Get the row as a parent of the link that was clicked on */
                    var nRow = $(this).parents('tr')[0];

                    if (nEditing !== null && nEditing != nRow) {
                        restoreRow(oTable, nEditing);
                        editRow(oTable, nRow);
                        nEditing = nRow;
                    } else if (nEditing == nRow && this.innerHTML == "Save") {
                        /* This row is being edited and should be saved */

                        // alert("Updated! Do not forget to do some ajax to sync with backend :)");
                        var jqInputs = $('input', nRow);
                        var updatedValues = {};
                        for(var i = 0; i < jqInputs.length; i++) {
                            updatedValues[columns[i]] = jqInputs[i].value;
                        }
                        console.log(updatedValues);
                        $http({
                            method: 'POST',
                            url: './updateStaff',
                            data: $.param(updatedValues),
                            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                        }).success(function (data, status, headers, config) {
                            saveRow(oTable, nEditing);
                            nEditing = null;
                        });
                    } else {
                        /* No row currently being edited */
                        editRow(oTable, nRow);
                        nEditing = nRow;
                    }
                });

                $('.dataTables_filter input').attr("placeholder", "Search a user...");

            };

            editableTable();
        });

        $scope.$on('$destroy', function () {
            $('table').each(function () {
                if ($.fn.dataTable.isDataTable($(this))) {
                    $(this).dataTable({
                        "bDestroy": true
                    }).fnDestroy();
                }
            });
        });
    }]);