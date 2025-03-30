<template>
  <view class="content">
    <view
      :style='{"minHeight":"100vh","width":"100%","padding":"24rpx 24rpx 80rpx","position":"relative","background":"#eefcff","height":"auto"}'>
      <form
        :style='{"padding":"24rpx 48rpx","boxShadow":"0 4rpx 12rpx #76c4d880","borderRadius":"60rpx","background":"#fff","display":"block","width":"100%","height":"auto"}'
        class="app-update-pv">

        <!-- 菜品名称 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class="">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">菜品名称</view>
          <input
            :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'
            :disabled="ro.caipinmingcheng" v-model="ruleForm.caipinmingcheng" placeholder="菜品名称"></input>
        </view>

        <!-- 食谱分类 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class=" select">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">食谱分类</view>
          <picker :disabled="ro.shipufenlei" :style='{"width":"100%","flex":"1","height":"auto"}'
            @change="shipufenleiChange" :value="shipufenleiIndex" :range="shipufenleiOptions">
            <view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(255, 170, 51)"}'
              class="uni-input">{{ruleForm.shipufenlei?ruleForm.shipufenlei:"请选择食谱分类"}}</view>
          </picker>
        </view>

        <!-- 图片 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class="" @tap="tupianTap">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">图片</view>
          <image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}'
            class="avator" v-if="ruleForm.tupian" :src="baseUrl+ruleForm.tupian.split(',')[0]" mode="aspectFill">
          </image>
          <image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}'
            class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
        </view>

        <!-- 参考价格 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class="">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">参考价格</view>
          <input
            :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'
            :disabled="ro.cankaojiage" v-model.number="ruleForm.cankaojiage" placeholder="参考价格"></input>
        </view>

        <!-- 制作视频 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class="" @tap="zhizuoshipinTap">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">制作视频</view>
          <input
            :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}'
            v-if="ruleForm.zhizuoshipin" v-model="baseUrl+ruleForm.zhizuoshipin" placeholder="制作视频"></input>
          <image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}'
            class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
        </view>

        <!-- 发布时间 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class=" select">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">发布时间</view>
          <picker :disabled="ro.fabushijian" :style='{"width":"100%","flex":"1","height":"auto"}' mode="date"
            :value="ruleForm.fabushijian" @change="fabushijianChange">
            <view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(255, 170, 51)"}'
              class="uni-input">{{ruleForm.fabushijian?ruleForm.fabushijian:"请选择发布时间"}}</view>
          </picker>
        </view>

        <!-- 菜品材料 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class="">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">菜品材料</view>
          <textarea maxlength="500"
            :style='{"border":"0","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"400rpx"}'
            v-model="ruleForm.caipincailiao" placeholder="菜品材料"></textarea>
        </view>

        <!-- 菜品做法 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class="">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">菜品做法</view>
          <textarea maxlength="500"
            :style='{"border":"0","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"400rpx"}'
            v-model="ruleForm.caipinzuofa" placeholder="菜品做法"></textarea>
        </view>

        <!-- 制作时长 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class="">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">制作时长</view>
          <textarea
            :style='{"border":"0","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"400rpx"}'
            v-model="ruleForm.zhizuoshichang" placeholder="制作时长"></textarea>
        </view>

        <!-- 菜品简介 -->
        <view
          :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ff0000","alignItems":"center","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'
          class="">
          <view
            :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'
            class="title">菜品简介</view>
          <textarea
            :style='{"border":"0","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"400rpx"}'
            v-model="ruleForm.caipinjianjie" placeholder="菜品简介"></textarea>
        </view>

        <!-- 提交 -->
        <view
          :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"auto"}'
          class="btn">
          <button
            :style='{"border":"0","padding":"0px","margin":"0 0 40rpx","color":"rgb(255, 255, 255)","borderRadius":"60rpx","background":"#76c4d8","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}'
            @tap="onSubmitTap" class="bg-red">提交</button>
        </view>
      </form>

      <w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="clicktimeConfirm" ref="clicktime"
        themeColor="#333333"></w-picker>
    </view>
  </view>
</template>

<script>
  import wPicker from "@/components/w-picker/w-picker.vue";
  import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
  export default {
    data() {
      return {
        cross: '',
        ruleForm: {
          caipinmingcheng: '',
          shipufenlei: '',
          tupian: '',
          cankaojiage: '',
          caipincailiao: '',
          caipinzuofa: '',
          zhizuoshichang: '',
          zhizuoshipin: '',
          fabushijian: '',
          caipinjianjie: '',
          shhf: '',
          discussnum: '',
          userid: '',
          storeupnum: '',
        },
        shipufenleiOptions: [],
        shipufenleiIndex: 0,
        // 登录用户信息
        user: {},
        ro: {
          caipinmingcheng: false,
          shipufenlei: false,
          tupian: false,
          cankaojiage: false,
          caipincailiao: false,
          caipinzuofa: false,
          zhizuoshichang: false,
          zhizuoshipin: false,
          fabushijian: false,
          caipinjianjie: false,
          sfsh: false,
          shhf: false,
          thumbsupnum: false,
          crazilynum: false,
          clicktime: false,
          clicknum: false,
          discussnum: false,
          userid: false,
          storeupnum: false,
        },
      }
    },
    components: {
      wPicker,
      multipleSelect,
    },
    computed: {
      baseUrl() {
        return this.$base.url;
      },



    },
    async onLoad(options) {
      this.ruleForm.fabushijian = this.$utils.getCurDate();
      let table = uni.getStorageSync("nowTable");
      // 获取用户信息
      let res = await this.$api.session(table);
      this.user = res.data;

      // ss读取


      // 下拉框
      res = await this.$api.option(`shipufenlei`, `shipufenlei`, {});
      this.shipufenleiOptions = res.data;
      this.shipufenleiOptions.unshift("请选择食谱分类");

      // 如果有登录，获取登录后保存的userid
      this.ruleForm.userid = uni.getStorageSync("appUserid")
      if (options.refid) {
        // 如果上一级页面传递了refid，获取改refid数据信息
        this.ruleForm.refid = options.refid;
        this.ruleForm.nickname = uni.getStorageSync("nickname");
      }
      // 如果是更新操作
      if (options.id) {
        this.ruleForm.id = options.id;
        // 获取信息
        res = await this.$api.info(`meishicaipu`, this.ruleForm.id);
        this.ruleForm = res.data;
      }
      // 跨表
      this.cross = options.cross;
      if (options.cross) {
        var obj = uni.getStorageSync('crossObj');
        for (var o in obj) {
          if (o == 'caipinmingcheng') {
            this.ruleForm.caipinmingcheng = obj[o];
            this.ro.caipinmingcheng = true;
            continue;
          }
          if (o == 'shipufenlei') {
            this.ruleForm.shipufenlei = obj[o];
            this.ro.shipufenlei = true;
            continue;
          }
          if (o == 'tupian') {
            this.ruleForm.tupian = obj[o].split(",")[0];
            this.ro.tupian = true;
            continue;
          }
          if (o == 'cankaojiage') {
            this.ruleForm.cankaojiage = obj[o];
            this.ro.cankaojiage = true;
            continue;
          }
          if (o == 'caipincailiao') {
            this.ruleForm.caipincailiao = obj[o];
            this.ro.caipincailiao = true;
            continue;
          }
          if (o == 'caipinzuofa') {
            this.ruleForm.caipinzuofa = obj[o];
            this.ro.caipinzuofa = true;
            continue;
          }
          if (o == 'zhizuoshichang') {
            this.ruleForm.zhizuoshichang = obj[o];
            this.ro.zhizuoshichang = true;
            continue;
          }
          if (o == 'zhizuoshipin') {
            this.ruleForm.zhizuoshipin = obj[o];
            this.ro.zhizuoshipin = true;
            continue;
          }
          if (o == 'fabushijian') {
            this.ruleForm.fabushijian = obj[o];
            this.ro.fabushijian = true;
            continue;
          }
          if (o == 'caipinjianjie') {
            this.ruleForm.caipinjianjie = obj[o];
            this.ro.caipinjianjie = true;
            continue;
          }
          if (o == 'thumbsupnum') {
            this.ruleForm.thumbsupnum = obj[o];
            this.ro.thumbsupnum = true;
            continue;
          }
          if (o == 'crazilynum') {
            this.ruleForm.crazilynum = obj[o];
            this.ro.crazilynum = true;
            continue;
          }
          if (o == 'clicktime') {
            this.ruleForm.clicktime = obj[o];
            this.ro.clicktime = true;
            continue;
          }
          if (o == 'clicknum') {
            this.ruleForm.clicknum = obj[o];
            this.ro.clicknum = true;
            continue;
          }
          if (o == 'discussnum') {
            this.ruleForm.discussnum = obj[o];
            this.ro.discussnum = true;
            continue;
          }
          if (o == 'userid') {
            this.ruleForm.userid = obj[o];
            this.ro.userid = true;
            continue;
          }
          if (o == 'storeupnum') {
            this.ruleForm.storeupnum = obj[o];
            this.ro.storeupnum = true;
            continue;
          }
        }
      }
      this.styleChange()
      this.$forceUpdate()
    },
    methods: {
      styleChange() {
        this.$nextTick(() => {
          // document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
          //   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
          // })
        })
      },

      // 多级联动参数

      fabushijianChange(e) {
        this.ruleForm.fabushijian = e.target.value;
        this.$forceUpdate();
      },

      // 日长控件选择日期时间
      clicktimeConfirm(val) {
        console.log(val)
        this.ruleForm.clicktime = val.result;
        this.$forceUpdate();
      },

      // 下拉变化
      shipufenleiChange(e) {
        this.shipufenleiIndex = e.target.value
        this.ruleForm.shipufenlei = this.shipufenleiOptions[this.shipufenleiIndex]
      },

      tupianTap() {
        let _this = this;
        this.$api.upload(function(res) {
          _this.ruleForm.tupian = 'upload/' + res.file;
          _this.$forceUpdate();
          _this.$nextTick(() => {
            _this.styleChange()
          })
        });
      },
      zhizuoshipinTap() {
        let _this = this;
        this.$api.upload(function(res) {
          _this.ruleForm.zhizuoshipin = 'upload/' + res.file;
          _this.$forceUpdate();
          _this.$nextTick(() => {
            _this.styleChange()
          })
        });
      },

      getUUID() {
        return new Date().getTime();
      },
      async onSubmitTap() {
        //跨表计算判断
        var obj;
        if (this.ruleForm.cankaojiage && (!this.$validate.isNumber(this.ruleForm.cankaojiage))) {
          this.$utils.msg(`参考价格应输入数字`);
          return
        }
        if (this.ruleForm.thumbsupnum && (!this.$validate.isIntNumer(this.ruleForm.thumbsupnum))) {
          this.$utils.msg(`赞应输入整数`);
          return
        }
        if (this.ruleForm.crazilynum && (!this.$validate.isIntNumer(this.ruleForm.crazilynum))) {
          this.$utils.msg(`踩应输入整数`);
          return
        }
        if (this.ruleForm.clicknum && (!this.$validate.isIntNumer(this.ruleForm.clicknum))) {
          this.$utils.msg(`点击次数应输入整数`);
          return
        }
        if (this.ruleForm.discussnum && (!this.$validate.isIntNumer(this.ruleForm.discussnum))) {
          this.$utils.msg(`评论数应输入整数`);
          return
        }
        if (this.ruleForm.storeupnum && (!this.$validate.isIntNumer(this.ruleForm.storeupnum))) {
          this.$utils.msg(`收藏数应输入整数`);
          return
        }
        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        if (this.cross) {
          uni.setStorageSync('crossCleanType', true);
          var statusColumnName = uni.getStorageSync('statusColumnName');
          var statusColumnValue = uni.getStorageSync('statusColumnValue');
          if (statusColumnName != '') {
            if (!obj) {
              obj = uni.getStorageSync('crossObj');
            }
            if (!statusColumnName.startsWith("[")) {
              for (var o in obj) {
                if (o == statusColumnName) {
                  obj[o] = statusColumnValue;
                }

              }
              var table = uni.getStorageSync('crossTable');
              await this.$api.update(`${table}`, obj);
            } else {
              crossuserid = Number(uni.getStorageSync('appUserid'));
              crossrefid = obj['id'];
              crossoptnum = uni.getStorageSync('statusColumnName');
              crossoptnum = crossoptnum.replace(/\[/, "").replace(/\]/, "");
            }
          }
        }
        if (crossrefid && crossuserid) {
          this.ruleForm.crossuserid = crossuserid;
          this.ruleForm.crossrefid = crossrefid;
          let params = {
            page: 1,
            limit: 10,
            crossuserid: crossuserid,
            crossrefid: crossrefid,
          }
          let res = await this.$api.list(`meishicaipu`, params);
          if (res.data.total >= crossoptnum) {
            this.$utils.msg(uni.getStorageSync('tips'));
            uni.removeStorageSync('crossCleanType');
            return false;
          } else {
            //跨表计算
            if (this.ruleForm.id) {
              await this.$api.update(`meishicaipu`, this.ruleForm);
            } else {
              await this.$api.add(`meishicaipu`, this.ruleForm);
            }
            this.$utils.msgBack('提交成功');
          }
        } else {
          //跨表计算
          if (this.ruleForm.id) {
            await this.$api.update(`meishicaipu`, this.ruleForm);
          } else {
            await this.$api.add(`meishicaipu`, this.ruleForm);
          }
          this.$utils.msgBack('提交成功');
        }
      },
      optionsChange(e) {
        this.index = e.target.value
      },
      bindDateChange(e) {
        this.date = e.target.value
      },
      getDate(type) {
        const date = new Date();
        let year = date.getFullYear();
        let month = date.getMonth() + 1;
        let day = date.getDate();
        if (type === 'start') {
          year = year - 60;
        } else if (type === 'end') {
          year = year + 2;
        }
        month = month > 9 ? month : '0' + month;;
        day = day > 9 ? day : '0' + day;
        return `${year}-${month}-${day}`;
      },
      toggleTab(str) {
        if (this.ro[str]) {
          return false
        }
        this.$refs[str].show();
      }
    }
  }
</script>

<style lang="scss" scoped>
  .content {
    min-height: calc(100vh - 44px);
    box-sizing: border-box;
  }
</style>