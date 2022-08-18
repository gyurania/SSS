<template>
  <section class="section section-shaped section-lg my-0">
    <div class="shape shape-style-1 bg-gradient-default"></div>
    <div class="container pt-lg-md">
      <card
        type="secondary"
        shadow
        header-classes="bg-white pb-5"
        body-classes="px-lg-5 py-lg-2 row  justify-content-around my-lg-4"
        class="border-0"
      >
        <!--서두-->
        <div class="top_naming text-left col-lg-12">
          <h3>
            <b>{{ teacher.name }}님의 상담일지 작성</b>
          </h3>
        </div>
        <!--본문 시작-->
        <div class=" memoReview mb-2 p-2">
          <img src="../../../public/img/brand/note2.png" alt="" />
          <h3><b>메모장</b></h3>
          <div class="memodata">
            <div style="display: flex; justify-content: space-between;">
              <p>{{ datas.memo }}</p>
            </div>
          </div>
        </div>
        <div class="CounWrite mb-2 p-2">
          <img src="../../../public/img/brand/note2.png" alt="" />
          <h3><b>상담일지 작성하기</b></h3>
          <textarea
            v-model="record"
            class="form-control writedown"
            id="exampleFormControlTextarea1"
            rows="10"
            placeholder="학부모에게 보여드릴 내용을 작성해주세요 ..."
          ></textarea>
        </div>

        <!--버튼-->
        <div class="col-sm-12 row justify-content-center mt-lg-5">
          <base-button @click="saveRecord" type="danger" class="col-md-2 mt-2"
            >완료</base-button
          >
          <base-button
            outline
            type="secondary"
            @click="$router.push('/childReserveShowCounselor')"
            class="col-md-2 mt-2"
            >취소</base-button
          >
        </div>
      </card>
    </div>
  </section>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import axios from "axios";
export default {
  created() {
    console.log(this.$route.params);
  },
  mounted() {
    console.log(this.$route.params);
  },
  data() {
    return {
      datas: this.$route.params,
      record: this.$route.params.record,
    };
  },
  computed: {
    ...mapState({
      teacher: (state) => state.teacher.teacher,
    }),
  },
  methods: {
    saveRecord() {
      axios
        .put("https://i7a606.q.ssafy.io/service-api/consult/record", {
          consultNo: this.datas.consultNo,
          record: this.record,
        })
        .then((res) => {
          console.log(res.data);
          console.log("success");
        });
      this.record = null;
      this.$router.push("/childReserveShowCounselor");
    },
  },
};
</script>

<style scoped>
.top_naming {
}
.section {
  height: 100%;
}
.memoReview {
  position: relative;
  width: 40%;
}
.memoReview > img {
  width: 100%;
  position: absolute;
}
.memoReview > h3 {
  position: relative;
  padding: 40px 30px;
}

.CounWrite > img {
  width: 100%;
  position: absolute;
}
.CounWrite > h3 {
  position: relative;
  padding: 40px 30px;
}
.memodata {
  position: relative;
  border: 1px solid #fff;
  margin: 0 20px;
}
.CounWrite {
  width: 40%;
  position: relative;
  height: 465px;
}
.writedown {
  line-height: 1.8rem;
  width: 94%;
  margin-left: 20px;
  position: relative;
  border: 1px solid #fff;
  background-color: #ffea89;
  font-size: large;
}
.writedown:focus {
  line-height: 1.8rem;
  color: rgb(44, 44, 44);
  border: 1px solid #fff;
  font-size: large;
  background-color: #ffea89;
}
button {
  border: 1px solid #dcdcdc;
}
@media (min-height: 938px) {
  .section {
    height: 100vh;
  }
}
</style>
