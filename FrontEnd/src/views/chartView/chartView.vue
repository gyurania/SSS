<template>
  <div class="profile-page">
    <section class="section-profile-cover section-shaped my-0">
      <div class="shape shape-style-1 shape-primary shape-skew alpha-4"></div>
    </section>

    <section class="section section-skew p-0">
      <div class="container">
        <card shadow class="py-5 px-md-5 card-profile mt--300" no-body>
          <div id="titleDiv">
            <h1>{{ this.childData.childName }} 님의 게임 기록</h1>
          </div>

          <div id="baseDiv">
            <LineChart :childId="this.childData.childId" id="chartDiv" />
            <base-button id="moveChildrenBtn" @click="moveChildren"
              >뒤로가기</base-button
            >
          </div>
        </card>
      </div>
    </section>
  </div>
</template>

<script>
import LineChart from "@/components/chartComp/Line.vue";

export default {
  methods: {
    moveChildren() {
      this.$router.push({ name: "children" });
    },
  },
  data() {
    return {
      childData: this.$route.params,
    };
  },
  components: {
    LineChart,
  },
};
</script>
<style scoped>
#baseDiv {
  display: flex;
  justify-content: center;
}

#chartDiv {
  margin-top: 10%;
  width: 50%;
  height: 50%;
}

#moveChildrenBtn {
  margin-top: 30%;
  height: 5%;
}

#titleDiv {
  margin-top: 5%;
  display: flex;
  justify-content: center;
}
</style>
