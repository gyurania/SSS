<template>
  <!--상담사만 봄 상담일지 볼 탭-->
  <div class="overflow-auto  text-center">
    <b-table
      hover
      id="my-table2"
      :items="items"
      :per-page="perPage"
      :current-page="currentPage"
      small
      :fields="fields"
      @row-clicked="counReview"
    >
    </b-table>
    <b-pagination
      v-model="currentPage"
      :total-rows="totalRecord"
      :per-page="perPage"
      aria-controls="my-table2"
      align="center"
    ></b-pagination>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      totalRecord: 0,
      perPage: 5,
      currentPage: 1,
      fields: [
        {
          key: "NO",
          sortable: true,
        },
        {
          key: "date",
          label: "날짜",
          soratable: true,
        },
        {
          key: "time",
          label: "시간",
          soratable: true,
        },
        {
          key: "theraName",
          label: "상담사",
          soratable: true,
        },
        {
          key: "record",
          label: "상담일지",
          soratable: false,
        },
      ],
      items: [],
    };
  },
  computed: {
    rows() {
      return this.items.length;
    },
  },
  created() {
    console.log("특정아동 상담내역");
    axios({
      url: `https://i7a606.q.ssafy.io/service-api/consult/parentcount/${this.$store.state.accounts.userid}/${this.$store.state.accounts.childInfo.childId}`,
      method: 'get'
    })
      .then(res => {
        this.totalRecord = res.data
        console.log(`토탈 레코드: ${res.data}`)
        axios({
          url: `https://i7a606.q.ssafy.io/service-api/consult/parent/${this.$store.state.accounts.userid}/${this.$store.state.accounts.childInfo.childId}/${this.currentPage}/${res.data}`,
          method: 'get'
        })
          .then(res => {
            this.items = res.data
            for (let i = 0; i < this.items.length; i++) {
              this.items[i]["NO"] = i + 1
              const date = this.items[i]["startedTime"].slice(0, 10)
              const time = `${Number(this.items[i]["startedTime"].slice(11, 13)) + 9}시 ${this.items[i]["startedTime"].slice(14, 16)}분`
              this.items[i]["date"] = date
              this.items[i]["time"] = time
            }
            console.log(this.items)
          })
          .catch(err => {
            console.log(err.response)
          })
      })
      .catch(err => {
        console.log(err.response)
      })

    axios({  // accessToken 재발급
      url: `https://i7a606.q.ssafy.io/service-api/auth/refresh/${this.$store.state.accounts.userid}`,
      method: 'get',
      headers: { Authorization: `Bearer ${this.$store.state.accounts.refreshToken}`}
    })
      .then(res => {
        console.log(res.data)
        this.$store.state.accounts.accessToken = res.data.accessToken
      })
      .catch(err => {
        console.log(err.response)
      })
    
  },
  // watch: {
  //   currentPage() {
  //     this.getItems()
  //   }
  // },
  methods: {
    counReview(item) {
      console.log(item["memo"], item["consultNo"])
      this.$router.push({ name: "ConsultReview", params: { record: item["record"], theraName: item["theraName"]} });
    },
  //   getItems(item) {
  //     console.log(this.currentPage)
  //     axios({
  //       // url: `https://i7a606.q.ssafy.io/service-api/consult/parent/${this.$store.state.accounts.userid}/${this.$route.params.childId}/${this.currentPage}}/${this.perPage}`,
  //       url: `https://i7a606.q.ssafy.io/service-api/consult/thearpist/tLQDOys220805/cMJwqp1220804/${this.currentPage}/${this.perPage}`,  // 확인용
  //       method: 'get'
  //     })
  //       .then(res => {
  //         let list = [...res.data]
  //         for (let i = 0; i < this.items.length; i++) {
  //           list[i]["NO"] = i + 1
  //           const date = list[i]["startedTime"].slice(0, 10)
  //           const time = list[i]["startedTime"].slice(11, 16)
  //           list[i]["date"] = date
  //           list[i]["time"] = time
  //           list[i]["content"] = list[i]["record"]
  //         }
  //         this.items = list
  //         console.log(this.items)
  //       })
  //       .catch(err => {
  //         console.log(err.response)
  //       })
  //   }
  },
};
</script>
<style scoped>
#my-table2 {
  cursor: pointer;
}
</style>
