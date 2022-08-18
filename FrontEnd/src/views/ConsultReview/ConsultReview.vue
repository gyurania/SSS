<template>
  <section class="section section-shaped section-lg my-0">
    <div class="shape shape-style-1 bg-gradient-default"></div>
    <div class="container pt-lg-md">
      <!--서두-->
      <h3>
        <div class="top_naming text-left mb-5">
          <b>{{ theraName }} 상담사의 상담일지</b>
        </div>
      </h3>
      <card
        type="secondary"
        shadow
        header-classes="bg-white pb-5"
        body-classes="px-lg-5 py-lg-5 row  justify-content-around my-lg-5"
        class="border-0"
      >
        <!--본문 시작-->
        <div class="col-md-5 CounWrite mb-2 p-2">
          <h3><b>상담일지</b></h3>
          <hr>
          {{ record }}
        </div>

        <!--버튼-->
        <div class="col-sm-12 row justify-content-center mt-lg-5">
          <base-button @click="$router.push('/childReserveShow')" class="col-md-2 mt-2">확인</base-button>
        </div>
      </card>
    </div>
  </section>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      theraName: this.$route.params.theraName,
      record: this.$route.params.record
    }
  },
}
</script>

<style scoped>
.section {
  height: 100%;
}
.memoReview {
  border-radius: 15px;
  background-color: #ffeebb;
}
.CounWrite {
  border-radius: 15px;
  background-color: #ffeebb;
}
</style>
