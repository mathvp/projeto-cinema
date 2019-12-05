<template>
  <div class="movies container">
    <h1>Lista de Salas</h1>
    <RoomsTable />
  </div>
</template>

<script>

import RoomsTable from '@/components/RoomsTable'

export default {
  name: 'Rooms',
  components: {
    RoomsTable
  }
}
</script>
