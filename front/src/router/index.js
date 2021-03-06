import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Movie from '../views/movie/Movie.vue'
import NewMovie from '../views/movie/NewMovie.vue'
import Room from '../views/room/Room.vue'
import NewRoom from '../views/room/NewRoom.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/filmes',
    name: 'movies',
    component: () => import(/* webpackChunkName: "about" */ '../views/movie/Movies.vue')
  },
  {
    path: '/filme/:movie_id',
    name: 'movieShow',
    component: Movie
  },
  {
    path: '/filmes/novo',
    name: 'newMovie',
    component: NewMovie
  },
  {
    path: '/salas',
    name: 'rooms',
    component: () => import(/* webpackChunkName: "about" */ '../views/room/Rooms.vue')
  },
  {
    path: '/salas/:room_id',
    name: 'roomShow',
    component: Room
  },
  {
    path: '/salas/novo',
    name: 'newRoom',
    component: NewRoom
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
