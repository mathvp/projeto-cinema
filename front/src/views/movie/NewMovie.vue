<template>
  <div class="movies container">
    <h1> Cadastro de Filme</h1>
    <div class="movie-info content">
      <div class="movie-preview-img">        
      </div>
      <div class="movie-data">
        <form id="form" action="" method="post" @submit="formSubmit">
          <h4>Informe os dados do filme no formulário abaixo:</h4>
          <fieldset>
            <label for="">Título do Filme</label>
            <input v-model="titulo" placeholder="Ex.: De volta para o futuro" type="text" tabindex="1" required autofocus>
          </fieldset>
          <fieldset>
            <label for="">Duração em minutos</label>
            <input v-model="duracao" placeholder="Ex.: 120" type="number" tabindex="2" required><span class="movie-duration">min</span>
          </fieldset>
          
          <fieldset>
            <label for="">Descrição</label>
            <textarea v-model="descricao" placeholder="Sinopse" tabindex="5" ></textarea>
          </fieldset>
          <fieldset>
            <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
          </fieldset>
          {{output}}
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'NewMovie',
  data() {
    return {
      titulo: '',
      duracao: '',
      descricao: '',
      output: ''
    }
  },
  methods: {
      formSubmit(e) {
          e.preventDefault();
          let currentObj = this;
          axios.post(process.env.VUE_APP_API_URL+"/filmes/novo",
           {
              titulo: this.titulo,
              duracao: this.duracao,
              descricao: this.descricao
          }
        )
          .then(function (response) {
              currentObj.output = response.data;
          })
          .catch(function (error) {
              currentObj.output = error;
          });
      }
  }
}
</script>

<style>

#form {
  padding: 25px;
}

#form h3 {
  display: block;
  font-size: 30px;
  font-weight: 300;
  margin-bottom: 10px;
}

#form h4 {
  margin: 5px 0 30px;
  display: block;
  font-weight: 400;
}

fieldset {
  border: medium none !important;
  margin: 0 0 30px;
  min-width: 100%;
  padding: 0;
  width: 100%;
}

#form input[type="text"],
#form input[type="number"],
#form input[type="tel"],
#form input[type="url"],
#form textarea {
  width: 100%;
  border: 1px solid #ccc;
  background: #FFF;
  margin: 0 0 5px;
  padding: 10px;
  border-radius: .3em;
}

#form input[type="text"]:hover,
#form input[type="number"]:hover,
#form input[type="tel"]:hover,
#form input[type="url"]:hover,
#form textarea:hover {
  -webkit-transition: border-color 0.3s ease-in-out;
  -moz-transition: border-color 0.3s ease-in-out;
  transition: border-color 0.3s ease-in-out;
  border: 1px solid #aaa;
}

#form textarea {
  height: 100px;
  max-width: 100%;
  resize: none;
}

#form button[type="submit"] {
  cursor: pointer;
  width: 100%;
  border: none;
  background: #b5121b;
  color: #FFF;
  margin: 0 0 5px;
  padding: 10px;
  font-size: 15px;
  font-weight: 700;
  text-transform: uppercase;
  border-radius: .2em;
}

#form button[type="submit"]:hover {
  background: #7f0209;
  -webkit-transition: background 0.3s ease-in-out;
  -moz-transition: background 0.3s ease-in-out;
  transition: background-color 0.3s ease-in-out;
}

#form button[type="submit"]:active {
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}

#form input:focus,
#form textarea:focus {
  outline: 0;
  border: 1px solid #aaa;
}

::-webkit-input-placeholder {
  color: #888;
}

:-moz-placeholder {
  color: #888;
}

::-moz-placeholder {
  color: #888;
}

:-ms-input-placeholder {
  color: #888;
}
label {
  width: 100%;  
  display: block;
}
#form input[type="number"] {
  max-width: 50%;
}

span.movie-duration {
  margin-left: 1em;
}
</style>

