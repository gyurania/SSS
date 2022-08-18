<template>
    <div class="profile-page">
        <section class="section-profile-cover section-shaped my-0">
            <div class="shape shape-style-1 shape-primary shape-skew alpha-4">
            </div>
        </section>
        <section class="section section-skew">
            <div class="container">
                <card shadow class="card-profile mt--300" no-body>
                    <div class="px-4">
                        <div class="row justify-content-center">
                            <div class="col-lg-3 order-lg-2">
                                <div class="card-profile-image">
                                    <a href="#">
                                      <div v-if="this.$store.state.accounts.userid.slice(0, 1) === 't'">
                                        <img
                                          :src="`data:image/png;base64,${userInfo['profile_url']}`"
                                          class="rounded-circle img-fluid shadow-lg"
                                        >
                                      </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-lg-4 order-lg-1">
                                <div class="card-profile-stats d-flex justify-content-center">
                                    <!-- <div>
                                        <span class="heading">22</span>
                                        <span class="description">Friends</span>
                                    </div>
                                    <div>
                                        <span class="heading">10</span>
                                        <span class="description">Photos</span>
                                    </div>
                                    <div>
                                        <span class="heading">89</span>
                                        <span class="description">Comments</span>
                                    </div> -->
                                </div>
                            </div>
                        </div>
                        <div class="text-center mt-5">
                            <h1>
                              {{ userInfo["name"] }}
                                <span class="font-weight-light"></span>
                            </h1>
                            <div class="contactInfo">
                              <h4>Contact</h4>
                              <div class="h6 font-weight-300"><i class="ni mr-2"></i>
                                {{ userInfo["email"] }}</div>
                              <div class="h6"><i class="ni business_briefcase-24 mr-2"></i>
                                {{ userInfo["phone"] }}</div>
                              <div><i class="ni education_hat mr-2"></i>
                                {{ userInfo["address"] }}</div>
                            </div>
                        </div>
                        <div class="mt-5 py-5 border-top text-center" v-if="this.$store.state.accounts.userid.slice(0, 1) === 't'">
                            <div class="row justify-content-center">
                                <div class="col-lg-9">
                                  <h4>전문분야</h4>
                                  <div v-for="(expertise, i) in userInfo.expertises" :key="i">
                                    {{ expertise["isKind"] }}
                                  </div>
                                  <hr>
                                  <h4>학력</h4>
                                  <div v-for="(aca, i) in userInfo.academy" :key="i">
                                    {{ aca["name"] }} {{ aca["major"] }}
                                  </div>
                                  <hr>
                                  <h4>경력</h4>
                                  <div v-for="(career, i) in userInfo.careers" :key="i">
                                    {{ career["name"] }} {{ career["role"] }}
                                  </div>
                                  <hr>
                                  <h4>자격증</h4>
                                  <div v-for="(lic, i) in userInfo.licence" :key="i">
                                    {{ lic["name"] }}
                                  </div>
                                  <hr>
                                  {{ userInfo["thera_intro"] }}
                                  <!-- <a href="#">Show more</a> -->
                                </div>
                            </div>
                        </div>
                        <router-link to="/update">
                          <base-button type="info" size="sm" class="mr-4">회원정보 수정</base-button>
                        </router-link>
                          <!-- <base-button type="default" size="sm" class="float-right">회원 탈퇴</base-button> -->
                    </div>
                  <!-- <div class="col-lg-4 order-lg-3 text-lg-right align-self-lg-center">
                      <div class="card-profile-actions py-4 mt-lg-0">
                        <router-link to="/update">
                          <base-button type="info" size="sm" class="mr-4">회원정보 수정</base-button>
                        </router-link>
                          <base-button type="default" size="sm" class="float-right">회원 탈퇴</base-button>
                      </div>
                  </div> -->
                </card>
            </div>
        </section>
    </div>
</template>
<script>
import axios from 'axios'

export default {
  name: 'profile',
  data() {
    return {
      userInfo: {}
    }
  },
  created() {
    console.log("프로필 페이지")
    axios({
      url: `https://i7a606.q.ssafy.io/service-api/user/${this.$store.state.accounts.userid}`,
      method: 'get',
      headers: { Authorization: `Bearer ${this.$store.state.accounts.accessToken}`}
    })
      .then((res) => {
        if (this.$store.state.accounts.userid.slice(0, 1) === 't') {
          console.log("상담사")
          console.log(res.data.theraInfo)
          this.userInfo = res.data.theraInfo
        } else {
          console.log(res.data.parentInfo)
          this.userInfo = res.data.parentInfo
        }
      })
      .catch(err => {
        console.log(err.response)
      })
    // axios({  // accessToken 재발급
    //   url: `https://i7a606.q.ssafy.io/service-api/auth/refresh/${this.$store.state.accounts.userid}`,
    //   method: 'get',
    //   headers: { Authorization: `Bearer ${this.$store.state.accounts.refreshToken}`}
    // })
    //   .then(res => {
    //     console.log(res.data)
    //     this.$store.state.accounts.accessToken = res.data.accessToken
    //   })
    //   .catch(err => {
    //     console.log(err.response)
    //   })
  }
};
</script>

<style>
.contactInfo {
  display: flex;
  flex-direction: column;
}
</style>
