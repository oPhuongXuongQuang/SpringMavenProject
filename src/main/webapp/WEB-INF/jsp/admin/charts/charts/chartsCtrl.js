'use strict';

/**
 * @ngdoc function
 * @name newappApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the newappApp
 */
angular.module('newApp')
  .controller('chartsCtrl', ['$scope', '$http', function ($scope, $http, chartService) {
      $scope.$on('$viewContentLoaded', function () {
          // chartService.init();

          $scope.chartCateLabels = [];
          $scope.chartCateData = [];
          $scope.chartCateBackground = [];
          $scope.chartCateHighlight = [];

          var promise = $http({
              method: "GET",
              url: "./getCategory"
          }).success(function (data) {
              $.each(data, function(pos, category) {
                  $scope.chartCateLabels.push(category['name']);
                  $scope.chartCateData.push(category['productList'].length);
                  var rand1 = Math.floor(Math.random() * 256);
                  var rand2 = Math.floor(Math.random() * 256);
                  var rand3 = Math.floor(Math.random() * 256);
                  $scope.chartCateBackground.push('rgba(' + rand1 + ','
                                              + rand2 + ','
                                              + rand3 + ','
                                              + 0.8 + ')');
                  $scope.chartCateHighlight.push('rgba(' + rand1 + ','
                                              + rand2 + ','
                                              + rand3 + ','
                                              + 1 + ')');

              })
          });

          function initChart () {
              // var pieData = [
              //     {value: 300, color: "rgba(54, 173, 199,0.9)", highlight: "rgba(54, 173, 199,1)", label: "Blue"},
              //     {value: 40, color: "rgba(201, 98, 95,0.9)", highlight: "rgba(201, 98, 95,1)", label: "Red"},
              //     {value: 100, color: "rgba(255, 200, 112,0.9)", highlight: "rgba(255, 200, 112,1)", label: "Yellow"},
              //     {value: 50, color: "rgba(27, 184, 152,0.9)", highlight: "rgba(27, 184, 152,1)", label: "Green"},
              //     {value: 120, color: "rgba(97, 103, 116,0.9)", highlight: "rgba(97, 103, 116,1)", label: "Dark Grey"}
              // ];
              // var pieData = $scope.chartCateData;

              var ctx = document.getElementById("pie-chart").getContext("2d");;
              // window.myPie = new Chart(ctx).Pie(pieData, {
              //     tooltipCornerRadius: 1
              // });
              window.myPie = new Chart(ctx, {
                  type: 'pie',
                  data: {
                      labels: $scope.chartCateLabels,
                      datasets: [{
                          label: 'Category of Product',
                          data: $scope.chartCateData,
                          backgroundColor: $scope.chartCateBackground,
                          borderColor: $scope.chartCateHighlight,
                          borderWidth: 1
                      }]
                  }
              });
          }

          promise.then(initChart);

      });
  }]);
