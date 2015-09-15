function FyrsMap() {
	if (typeof FyrsMap.flagPut == "undefined") {
		FyrsMap.prototype.putFun = function(key, value) {
			this[key + "_"] = value;
		};
		FyrsMap.flagPut = true;
	}
	if (typeof FyrsMap.flagGet == "undefined") {
		FyrsMap.prototype.getFun = function(key) {
			return this[key + "_"];
		};
		FyrsMap.flagGet = true;
	}
	if (typeof FyrsMap.flagDelete == "undefined") {
		FyrsMap.prototype.deleteFun = function(key) {
			delete this[key + "_"];
		};
		FyrsMap.flagDelete = true;
	}
	if (typeof FyrsMap.flagList == "undefined") {
		FyrsMap.prototype.listFun = function() {
			var str = "";
			var pattern = /_$/;
			for ( var k in this) {
				if(k.match(pattern))
				{
					str += this[k];
				}
					
			}
			return str;
		};
		FyrsMap.flagList = true;
	}
	if (typeof FyrsMap.proptertyLength == "undefined") {
		FyrsMap.prototype.proptertyLengthFun = function() {
			var len = 0;
			var pattern = /_$/;
			for ( var k in this) {
				if(k.match(pattern))
				{
					len += 1;
				}
					
			}
			return len;
		};
		FyrsMap.proptertyLength = true;
	}
	if (typeof FyrsMap.proptertyJson == "undefined") {
		FyrsMap.prototype.proptertyJsonFun = function() {
			var pattern = /_$/;
			var result = '{';			
			for ( var k in this) {
				if(k.match(pattern))
				{
					 var jsonObject = '';
					 jsonObject = '"'+k.substring(0,k.length - 1)+'":[';
					 jsonObject += this[k].substring(0,this[k].length - 1);
					 jsonObject += '],';
					 result += jsonObject;
				}		
			}
			result = result.substring(0,result.length - 1);
			result += '}';
			return result;
		};
		FyrsMap.proptertyJson = true;
	}
	
	if (typeof FyrsMap.flagListProperty == "undefined") {
		FyrsMap.prototype.listFunProperty = function() {
			var array = [];
			var pattern = /_$/;
			for ( var k in this) {
				if(k.match(pattern))
				{
					array.push(k.substring(0,k.length - 1));
				}
					
			}
			return array;
		};
		FyrsMap.flagListProperty = true;
	}

}
function TableColumns()
{
  this["tSelect"] = new FyrsMap();
  this["tUnSelect"] = new FyrsMap();
  this['isLoad'] = false;
}
