<template>
  <div class="movies container">
    <h1>Lista de Salas</h1>
    <MoviesTable />
  </div>
</template>

<script>

import MoviesTable from '@/components/RoomsTable'

export default {
  name: 'Rooms',
  components: {
    RoomsTable
  }
}
</script>
