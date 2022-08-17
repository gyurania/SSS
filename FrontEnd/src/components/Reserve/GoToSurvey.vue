<template>
  <div>
    <base-button
      outline
      type="secondary"
      class="childbutton"
      @click="modals.modal1 = true"
    >
      상담사추천
    </base-button>
    <modal :show.sync="modals.modal1">
      <h6 slot="header" class="modal-title text-left" id="modal-title-default">
        <h5 class=" pt-md-5 px-md-2">
          <h5>문진표가 작성되지 않았습니다.</h5>
          <h5>문진표 작성 후 예약해주세요.</h5>
        </h5>
      </h6>
      <router-link to="/survey" class="col-lg-6 px-0">
        <base-button type="primary" class="childbutton">문진표작성</base-button>
      </router-link>
    </modal>
  </div>
</template>

<script>
import Modal from "@/components/Modal.vue";
import BaseButton from "../BaseButton.vue";
export default {
  components: {
    Modal,
  },
  data() {
    BaseButton;
    return {
      modals: {
        modal1: false,
      },
    };
  },
};
</script>

<style scoped>
/* 자녀관리 하단의 문진표보기 등 버튼 */
.childbutton {
  margin: 10px;
  width: 80%;
  border: 1px solid rgb(237, 237, 237);
}
/* 버튼 관련~~~~ */

button:focus,
button:active {
  outline: none;
  box-shadow: none;
}
.childbutton:hover {
  background-color: #ffdcb8;
  border: 1px solid #dcdcdc;
}
.card_about p {
  margin-bottom: 1px;
  color: #000;
}
</style>
