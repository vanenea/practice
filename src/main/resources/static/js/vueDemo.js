var app = new Vue({
	el:"#h",
	data:{
		message:'hello vue!'
	}
})

Vue.component('todo-item', {
	props: ['todo'],
	template: '<li>{{ todo.text }}</li>'
})

var app7 = new Vue({
  el: '#app-7',
  data: {
    groceryList: [
      { id: 0, text: '蔬菜' },
      { id: 1, text: '奶酪' },
      { id: 2, text: '随便其它什么人吃的东西' }
    ]
  }
})

var app8 = new Vue({
	el: '#app-8',
	data: {
	    groceryList: [
	      { id: 0, text: '蔬菜' },
	      { id: 1, text: '奶酪' },
	      { id: 2, text: '随便其它什么人吃的东西' }
	    ]
	},
	methods:{
		test:function(){
			alert("test")
		}
	}
})
