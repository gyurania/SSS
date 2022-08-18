<template>

  <div class="profile-page">
    <section class="section-profile-cover section-shaped my-0">
      <div class="shape shape-style-1 shape-primary shape-skew alpha-4"></div>
    </section>

    <section class="section section-skew p-0">
      <div class="container">
        <card shadow class="py-5 px-md-5 card-profile mt--300" no-body>
          <div id="titleDiv">
            <h1 id="titleH1">{{ this.childData.childName }} 님의 놀이 기록</h1>
          </div>

          <div id="baseDiv">
            <LineChart :childId="this.childData.childId" id="chartDiv" />
          </div>
          <div id="backBtnDiv">
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
  width: 100%;
}

#chartDiv {
  margin-top: 0;
  width: 100%;
  height: 100%;
}

#moveChildrenBtn {
  margin-top: 0;
  height: 5%;
  width: 10%;
}

#titleDiv {
  margin-top: 5%;
  margin-bottom: 0;
  display: flex;
  justify-content: center;
}

#backBtnDiv {
  display: flex;
  justify-content: center;
  margin-top: 1%;
}

#titleH1 {
  margin: 0;
}
</style>
