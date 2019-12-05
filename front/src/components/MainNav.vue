<template>
  <div class="main-nav">
    <nav>
      <div id="logo">
        <router-link :to="{ name: 'home' }">CINEMASTER</router-link>
      </div>

      <label for="drop" class="toggle">Menu</label>
      <input type="checkbox" id="drop" />
        <ul class="menu">
          <li><router-link :to="{ name: 'home' }">Início</router-link></li>
          <li>
            <label for="drop-1" class="toggle">Sessões</label>
            <a href="#">Sessões</a>
            <input type="checkbox" id="drop-1"/>
            <ul>
                <li><a href="#">Listar Sessões</a></li>
                <li><a href="#">Cadastrar Sessão</a></li>
            </ul> 
          </li>

          <li>
            <label for="drop-2" class="toggle">Filmes</label>
            <router-link :to="{ name: 'movies' }">Filmes</router-link>
            <input type="checkbox" id="drop-2"/>
            <ul>
              <li><router-link :to="{ name: 'movies' }">Listar Filmes</router-link></li>
              <li><router-link :to="{ name: 'newMovie' }">Cadastrar Filme</router-link></li>
            </ul>
          </li>

          <li>
            <label for="drop-3" class="toggle">Salas</label>
            <a href="/salas">Salas</a>
            <input type="checkbox" id="drop-3"/>
            <ul>
              <li><a href="/salas">Listar Salas</a></li>
              <li><a href="/salas/novo">Cadastrar Sala</a></li>
            </ul>
          </li>
          <li><a href="#">Teste</a></li>
          <li><a href="#">Teste</a></li>
        </ul>
      </nav>
  </div>
</template>

<script>
export default {
  name: 'MainNav'
}
</script>
