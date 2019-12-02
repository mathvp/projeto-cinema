<template>
  <div class="movies-list">
    <div v-if="moviesList.length > 0" class="movies-wrapper container">
      <div v-for="movie in filteredMovies" :key="movie.id" :id="movie.id" class="movies-item">
        <router-link :to="{ name: 'movieShow', params: { movie_id: movie.id } }">
          <img src="https://www.cinemark.com.br/content/uploads/movie/7185/black-friday-midway-batalha-em-alto-mar-poster-desktop.jpg" alt="">
          <div class="description-overlay">
            <p class="description-text">
              {{movie.titulo}}
            </p>
          </div>
        </router-link>
      </div>
    </div>
    <div class="empty-list" v-if="moviesList.length == 0">
      <h4>Nenhum Filme encontrado...</h4>
    </div>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'MoviesList',
  data() {
    return {
      moviesList: []
    }
  },
  created() {
  },
  mounted() {
    axios.get(process.env.VUE_APP_API_URL+'/filmes')
    .then(response => {
      console.log("chegou aqui")
      this.moviesList = response.data
    })
  },
  computed: {
    filteredMovies() {
      return Array.from(this.moviesList).filter(movie => {
        return movie.status.toLowerCase().match('emcartaz')
      })
    }
  },
}
</script>

<style>
  .movies-list {
    background-color: #212121;
    display: flex;
    justify-content: center;
    padding: 60px 0;
    margin-bottom: 60px;
  }
  .movies-wrapper {
    flex-wrap:wrap;
    width: 100%;
    display: flex;
    justify-content: space-between;
  }

  .movies-item img, .description-overlay{
    border-radius: 10px;
    box-shadow: 1px 1px 1em rgba(0,0,0,.6);
  }

  .movies-item {
    position: relative;
    cursor: pointer;
  }

  .description-overlay {
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background: rgba(181, 18, 27, 0.75);
    color: #fff;
    visibility: hidden;
    opacity: 0;
    display: flex;
    align-items: center;
    justify-content: center;

    transition: opacity .2s, visibility .2s;
  }

  .movies-item:hover .description-overlay {
    visibility: visible;
    opacity: 1;
  }

  .description-text {
    transition: .2s;
    transform: translateY(1em);
  }

  .description-text a{
    color: #fff;
    text-shadow: 1px 2px 10px #000;
    font-weight: 700;
  }
  .movies-item:hover .description-text {
    transform: translateY(0);
  }

  .empty-list h4{
    color: #848484;
  }
</style>

