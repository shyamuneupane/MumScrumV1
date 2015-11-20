<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <base href="http://demos.telerik.com/kendo-ui/bar-charts/gap-spacing">
    <style>html { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="//kendo.cdn.telerik.com/2015.3.1111/styles/kendo.common-material.min.css" />
    <link rel="stylesheet" href="//kendo.cdn.telerik.com/2015.3.1111/styles/kendo.material.min.css" />

    <script src="//kendo.cdn.telerik.com/2015.3.1111/js/jquery.min.js"></script>
    <script src="//kendo.cdn.telerik.com/2015.3.1111/js/kendo.all.min.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<%@ include file="Header.jsp" %>
<div class="container">
  <ul class="nav nav-tabs">
    <li><a href="view.userstory">View All User Stories</a></li>
    <li><a href="view.sprint"> View All Sprint </a></li>
    <li><a href="view.release" >View All release</a> </li>
    <li class="active"><a href="view.SelectAttributeForBurnDown">View BurnDown Chart</a> </li>
  </ul>
<div id="example">
    <div class="demo-section k-content wide">
        <div id="chart"></div>
    </div>
   
</div>

 <fieldset>
			<legend><h3>Burn Down chart</h3></legend>
<div id="chart">		
<script>
    function createChart() {
        $("#chart").kendoChart(${DataforKendoChart });
    }

    $(document).ready(function () {
        createChart();

        $("#example").bind("kendo:skinChange", createChart);

        var chart = $("#chart").data("kendoChart"),
            firstSeries = chart.options.series;

        $("#getGap").click(function () {
            firstSeries[0].gap = parseFloat($("#gap").val(), 10);
            chart.redraw();
        });

        $("#getSpacing").click(function () {
            firstSeries[0].spacing = parseFloat($("#spacing").val(), 10);
            chart.redraw();
        });

        if (kendo.ui.NumericTextBox) {
            $("#gap").kendoNumericTextBox();
            $("#spacing").kendoNumericTextBox();
        }
    });
</script>
</div>
</div>

       
       
</body>
</html>
