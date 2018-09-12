/**
 * 工单表格相关
 */
var categoryList = null;
var workOrderList = null;

//加载工单表数据
$("#workOrderTbody").ready(function () {
    //从服务器获取当前时间
    $.post("/business/workOrder/getTime", function (data) {
        $("#workOrderFind").val(data);
        loadWorkOrderTableByDate(data);
    });
});

//对通过选择日期加载的列表删除操作
function deleteWorkOrderByIdForDateList(wid) {
    $("#workoOrderDeleteTbody").html("");
    var data = null;
    for (var i = 0; i < workOrderList.length; i++) {
        if (workOrderList[i].wid == wid) {
            data = workOrderList[i];
            break;
        }
    }
    var td = "<td id='deleteWorkOrderId'>" + data.wid + "</td>"
        + "<td>" + data.categoryName + "</td>"
        + "<td>" + data.operator + "</td>"
        + "<td>" + data.price + "</td>"
        + "<td>" + data.source + "</td>"
        + "<td>" + data.workDate + "</td>";
    var tr = "<tr style='text-align: center;'>" + td + "</tr>";
    $("#workoOrderDeleteTbody").append(tr);

    $('#workoOrderDeleteModal').modal();

    // $.post("/business/workOrder/removeWorkOrderById", {wid: wid}, function (data) {
    //     loadWorkOrderTableByDate($("#workOrderFind").val());
    // });
}

$("#workoOrderDeleteBtn").click(function () {
    $.post("/business/workOrder/removeWorkOrderById", {wid: $("#deleteWorkOrderId").text()}, function (data) {
        $('#workoOrderDeleteModal').modal('hide');
        loadWorkOrderTableByDate($("#workOrderFind").val());
    });
});


//根据日期查询
$("#workOrderFind").change(function () {
    loadWorkOrderTableByDate($("#workOrderFind").val());
});

//根据日期加载表格数据
function loadWorkOrderTableByDate(date) {
    $.post("/business/workOrder/getWorkOrderListByDate", {workDate: date}, function (data) {
        $("#workDate").val($("#workOrderFind").val());
        $("#workOrderTbody").html("");
        $("#sumt").html("工单列表");
        workOrderList = data;
        var sum = 0;
        for (var i = 0; i < data.length; i++) {
            sum += data[i].price;
            var btn = "<button type='button' class='btn btn-danger btn-xs' onclick='deleteWorkOrderByIdForDateList(" + data[i].wid + ")'>删除</button>";
            var td = "<td>" + data[i].wid + "</td>"
                + "<td>" + data[i].categoryName + "</td>"
                + "<td>" + data[i].operator + "</td>"
                + "<td>" + data[i].price + "</td>"
                + "<td>" + data[i].source + "</td>"
                + "<td>" + data[i].workDate + "</td>"
                + "<td>" + btn + "</td>";
            var tr = "<tr style='text-align: center;'>" + td + "</tr>";
            $("#workOrderTbody").append(tr);
        }
        $("#sumt").append("<br/>当天查询共查出：" + data.length + "条数据<br/>当天总计营业额：" + sum + "元");

    });
}

//工单列表添加操作
$("#workOrderModalSubBtn").click(function () {
    var wk = {
        categoryName: $("#categoryName").val(),
        operator: $("#operator").val(),
        price: $("#price").val(),
        source: $("#source").val(),
        workDate: $("#workDate").val()
    };
    $.post("/business/workOrder/addOneWorkOrder", wk, function (data) {
        $("#workOrderAddModal").modal("hide");
        loadWorkOrderTableByDate($("#workOrderFind").val());
        $("#payrollFind").val("");
    });

});
//获取类目信息
$("#workOrderAddForm").ready(function () {
    $.post("/business/category/getAllCategory", function (data) {
        for (var i = 0; i < data.length; i++) {
            $("#categoryName").append("<option>" + data[i].categoryName + "</option>");
        }
        categoryList = data;
    });
});

//选择类目之后填充价格
$("#categoryName").click(function () {
    var cn = $("#categoryName").val();
    for (var i = 0; i < categoryList.length; i++) {
        if (categoryList[i].cid + "." + categoryList[i].categoryName == cn) {
            $("#price").val(categoryList[i].categoryPrice);
            return;
        }
    }
});

/**
 * 类目操作
 */

//根据id删除
function deleteCategoryById(cid) {
    $.post("/business/category/removeOneCategory", {cid: cid}, function (data) {
        loadCategoryTable();
    })
}

//加载类目表
function loadCategoryTable() {
    $.post("/business/category/getAllCategory", function (data) {
        $("#categoryTbody").html("");
        //用来对修改过类目选择框重新加载数据
        $("#categoryName").html("");
        categoryList = data;
        for (var i = 0; i < data.length; i++) {
            $("#categoryName").append("<option>" + data[i].cid + "." + data[i].categoryName + "</option>");
            var btn = "<button type='button' class='btn btn-danger btn-xs' onclick='deleteCategoryById(" + data[i].cid + ")'>删除</button>";
            var td = "<td>" + data[i].cid + "</td>"
                + "<td>" + data[i].categoryName + "</td>"
                + "<td>" + data[i].categoryPrice + "</td>"
                + "<td>" + data[i].priceSource + "</td>"
                + "<td>" + btn + "</td>";
            var tr = "<tr style='text-align: center;'>" + td + "</tr>";
            $("#categoryTbody").append(tr);
        }
    });
}

$("#categoryTbody").ready(function () {
    loadCategoryTable();
});

//类目表添加按钮
$("#categoryModalSubBtn").click(function () {
    var cg = {
        categoryName: $("#cN").val(),
        categoryPrice: $("#categoryPrice").val(),
        priceSource: $("#priceSource").val()
    };
    $.post("/business/category/addOneCategory", cg, function (data) {
        $("#categoryAddModal").modal("hide");
        loadCategoryTable();
    });
});

/**
 * 人员管理表
 */

$("#PersonnelTbody").ready(function () {
    loadPersonnelTable();
});

function deletePersonnelById(pid) {
    $.post("/business/personnel/removeOnePersonnel", {pid: pid}, function (data) {
        loadPersonnelTable();
    });
}

$("#personnelModalSubBtn").click(function () {
    $.post("/business/personnel/addOnePersonnel", {
        name: $("#pname").val(),
        proportion: $("#proportion").val()
    }, function (data) {
        $("#personnelAddModal").modal("hide");
        loadPersonnelTable();
    });
});
personnelList = null;

function loadPersonnelTable() {
    $.post("/business/personnel/getAllPersonnel", function (data) {
        personnelList = data;
        $("#PersonnelTbody").html("");
        //用来对修改过类目选择框重新加载数据
        $("#operator").html("");
        categoryList = data;
        for (var i = 0; i < data.length; i++) {
            $("#operator").append("<option>" + data[i].name + "</option>");
            var btn = "<button type='button' class='btn btn-danger btn-xs' onclick='deletePersonnelById(" + data[i].pid + ")'>删除</button>";
            var td = "<td>" + data[i].pid + "</td>"
                + "<td>" + data[i].name + "</td>"
                + "<td>" + data[i].proportion + "</td>"
                + "<td>" + btn + "</td>";
            var tr = "<tr style='text-align: center;'>" + td + "</tr>";
            $("#PersonnelTbody").append(tr);
        }
    });
}

/**
 * 工资结算操作
 */

function loadPayrollTable() {
    $("#payrollTbody").html("");
    $.post("/business/payroll/getPayroll", {date: $("#payrollFind").val()}, function (data) {
        if (data == null || data == "") {
            alert("暂无数据");
        }

        for (var i = 0; i < data.length; i++) {
            var td = "<td>" + data[i].name + "</td>"
                + "<td>" + data[i].turnover + "</td>"
                + "<td>" + data[i].wage + "</td>";
            var tr = "<tr style='text-align: center;'>" + td + "</tr>";
            $("#payrollTbody").append(tr);
        }
    });
}

$("#payrollFind").change(function () {
    loadPayrollTable()
});


/**
 * 密码修改相关
 */


$("#changeUserModalSubBtn").click(function () {
    if (($("#un").val() == null || $("#un").val() == "")
        && (($("#oup").val() == null ||("#oup").val() == ""))
        && (($("#nup").val() == null || $("#nup").val() == ""))
    ) {
        alert("不允许为空");
    }else {
        var user = {
            un:$("#un").val(),
            oup:$("#oup").val(),
            nup:$("#nup").val()
        }
        $.post("/u/changeUser",user,function (data) {
            if (data=="ok"){
                alert("修改成功，跳转重新登录。");
                window.location.href="/noLogin";
            }else if (data=="err"){
                alert("修改失败，请重试");
            }

        });
    }
});
