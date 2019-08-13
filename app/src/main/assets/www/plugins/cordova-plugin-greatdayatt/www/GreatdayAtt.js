cordova.define("cordova-plugin-greatdayatt.GreatdayAtt", function(require, exports, module) {
var exec = require('cordova/exec');

module.exports.add = function (arg0, success, error) {
  console.log("function add");
    exec(success, error, 'GreatdayAtt', 'add', [arg0]);
};

module.exports.test = function (arg0, success, error) {
  console.log("function test");
    exec(success, error, 'GreatdayAtt', 'test', [arg0])
}

});
