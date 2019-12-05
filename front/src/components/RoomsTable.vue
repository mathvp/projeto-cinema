<template>
  <div class="movies-table content">
    <table v-if="roomsList">
      <thead>
        <tr>
          <th>#</th>
          <th>Numero</th>
          <th>Capacidade</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="room in filteredRooms" :key="room.id" :id="room.id">
          <td class="text-center">
            <router-link :to="{ name: 'roomShow', params: { room_id: room.id } }">{{room.id}}</router-link>
          </td>
          <td>
            <router-link :to="{ name: 'roomShow', params: { room_id: room.id } }">{{room.numeroSala}}</router-link>
          </td>
          <td>
            <router-link :to="{ name: 'roomShow', params: { room_id: room.id } }">{{room.limiteReserva}}</router-link>
          </td>
          <td>
            <router-link :to="{ name: 'roomShow', params: { room_id: room.id } }">{{room.status}}</router-link>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'RoomsTable',
  data() {
    return {
      roomsList: [],
      searchTerm: ''
    }
  },
  created() {
  },
  mounted() {
    axios.get(process.env.VUE_APP_API_URL+'/rooms')
    .then(response => {
      this.roomsList = response.data
    })
  },
  computed: {
    filteredRooms() {
      if(this.searchTerm === ''){
        return this.roomsList
      }
      return Array.from(this.roomsList).filter(room => {
        return room.numeroSala.match(this.searchTerm)
      })
    }
  }
}
</script>

<style>
  
</style>

