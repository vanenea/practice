/*! global-1.8.3.bq.js   包含：  ajax  返回上一页    时间格式化    补0  四则运算     2018-2-27*/
function json2url(json) {
	var arr = [];
	for (var name in json) {
		arr.push(name + '=' + json[name]);
	}
	return arr.join('&');
}

function ajax(json) {
	json = json || {};
	if (!json.url) return;
	json.data = json.data || {};
	json.type = json.type || 'get';

	var timer = null;

	if (window.XMLHttpRequest) {
		var oAjax = new XMLHttpRequest();
	} else {
		var oAjax = new ActiveXObject('Microsoft.XMLHTTP');
	}

	switch (json.type) {
		case 'get':
			oAjax.open('GET', json.url + '?' + json2url(json.data), true);
			oAjax.send();
			break;
		case 'post':
			oAjax.open('POST', json.url, true);
			oAjax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			oAjax.send(json2url(json.data));
			break;
		case 'put':
			oAjax.open('PUT', json.url, true);
			oAjax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			oAjax.send(json2url(json.data));
			break;
		case 'delete':
			oAjax.open('DELETE', json.url, true);
			oAjax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			oAjax.send(json2url(json.data));
			break;
	}

	oAjax.onreadystatechange = function() {
		if (oAjax.readyState == 4) {
			clearTimeout(timer);
			if (oAjax.status >= 200 && oAjax.status < 300 || oAjax.status == 304) {
				json.success && json.success(oAjax.responseText);
			} else {
				json.error && json.error(oAjax.status);
			}
		}
	};
}

function back() {
	window.history.back(-1);
}

Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 //月份 
       "d+" : this.getDate(),                    //日 
       "h+" : this.getHours(),                   //小时 
       "m+" : this.getMinutes(),                 //分 
       "s+" : this.getSeconds(),                 //秒 
       "q+" : Math.floor((this.getMonth()+3)/3), //季度 
       "S"  : this.getMilliseconds()             //毫秒 
   }; 
   if(/(y+)/.test(fmt)) {
           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
   }
    for(var k in o) {
       if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
   return fmt; 
}       

function bu0(str){
	str=Number(str);
	if(str>=0&&str<10){
		return "0"+str;
	}
	return str;
}

//除法
function accDiv(arg1, arg2) {
	var t1 = 0,
		t2 = 0,
		r1, r2;
	try {
		t1 = arg1.toString().split(".")[1].length
	} catch (e) {}
	try {
		t2 = arg2.toString().split(".")[1].length
	} catch (e) {}
	with(Math) {
		r1 = Number(arg1.toString().replace(".", ""))
		r2 = Number(arg2.toString().replace(".", ""))
		return accMul((r1 / r2), pow(10, t2 - t1));
	}
}
//乘法 
function accMul(arg1, arg2) {
	var m = 0,
		s1 = arg1.toString(),
		s2 = arg2.toString();
	try {
		m += s1.split(".")[1].length
	} catch (e) {}
	try {
		m += s2.split(".")[1].length
	} catch (e) {}
	return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
}
//加法  
function accAdd(arg1, arg2) {
	var r1, r2, m;
	try {
		r1 = arg1.toString().split(".")[1].length
	} catch (e) {
		r1 = 0
	}
	try {
		r2 = arg2.toString().split(".")[1].length
	} catch (e) {
		r2 = 0
	}
	m = Math.pow(10, Math.max(r1, r2))
	return (arg1 * m + arg2 * m) / m
}
//减法  
function Subtr(arg1, arg2) {
	var r1, r2, m, n;
	try {
		r1 = arg1.toString().split(".")[1].length
	} catch (e) {
		r1 = 0
	}
	try {
		r2 = arg2.toString().split(".")[1].length
	} catch (e) {
		r2 = 0
	}
	m = Math.pow(10, Math.max(r1, r2));
	n = (r1 >= r2) ? r1 : r2;
	return ((arg1 * m - arg2 * m) / m).toFixed(n);
}

