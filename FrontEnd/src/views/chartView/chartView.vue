<template>
  <div id="baseDiv">
    <LineChart :childId="this.childId" id="chartDiv" />
  </div>
</template>

<script>
import LineChart from '@/components/chartComp/Line.vue'

export default {
  props: {
    childId: String,
  },
  components: {
    LineChart
  }
}
</script>
<style scoped>
#baseDiv{
  display: flex;
  justify-content: center;
}

#chartDiv{
  margin-top: 10%;
  width: 50%;
  height: 50%;
}
</style>