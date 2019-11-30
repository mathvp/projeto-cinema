
//using template in component
Vue.component('hello-component', {
	template: '#hello',
	data: function () {
		return {
			msg: 'Olá '
		}
	},

	props: ['usuario']
});

Vue.filter('caixabaixa', (key) => {
	return key.toLowerCase()
})

new Vue({
	el: '#app',
	data: {
		contato: null
	},
	//a função definida em mounted é chamada quando o Vue
	mounted: function(){
		axios.get("http://localhost:8080/WebService-Exemplo/")
		.then(response =>  this.contato = response.data)
  		.catch(error => console.log(error));
	}
});