<template>
  <view class="content">
    <view class="box" :style='{
        "minHeight": "100vh",
        "width": "100%",
        "padding": "400rpx 24rpx 24rpx",
        "background": "url(../../static/register-bg.jpg) no-repeat center 40rpx / calc(100% - 60rpx) 350rpx, #fff",
        "height": "auto"
      }'>
      <view :style='{
          "padding": "44rpx 44rpx 64rpx 24rpx",
          "margin": "0 0 80rpx",
          "borderRadius": "40rpx",
          "textAlign": "center",
          "background": "rgba(255,255,255,.6)",
          "display": "block",
          "width": "100%",
          "position": "relative",
          "height": "auto"
        }'>
        <!-- 用户账号 -->
        <view :style='{
            "margin": "0 0 0px 0",
            "borderColor": "#ff0000",
            "textAlign": "left",
            "borderWidth": "0 0 2rpx",
            "display": "flex",
            "width": "100%",
            "borderStyle": "solid",
            "height": "auto",
            "alignItems": "center"
          }' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
          <view :style='{
              "width": "160rpx",
              "lineHeight": "76rpx",
              "fontSize": "28rpx",
              "color": "#666",
              "textAlign": "right",
              "fontWeight": "500"
            }' class="label">用户账号：</view>
          <input :style='{
              "border": "0px solid rgb(255, 170, 51)",
              "padding": "0px 24rpx",
              "margin": "0px",
              "color": "rgb(0, 0, 0)",
              "borderRadius": "8rpx",
              "flex": "1",
              "background": "rgba(255,255,255,.6)",
              "fontSize": "28rpx",
              "height": "76rpx"
            }' v-model="ruleForm.yonghuzhanghao" type="text" class="uni-input" name="" placeholder="用户账号" />
        </view>
        <!-- 密码 -->
        <view :style='{
            "margin": "0 0 0px 0",
            "borderColor": "#ff0000",
            "textAlign": "left",
            "borderWidth": "0 0 2rpx",
            "display": "flex",
            "width": "100%",
            "borderStyle": "solid",
            "height": "auto",
            "alignItems": "center"
          }' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
          <view :style='{
              "width": "160rpx",
              "lineHeight": "76rpx",
              "fontSize": "28rpx",
              "color": "#666",
              "textAlign": "right",
              "fontWeight": "500"
            }' class="label">密码：</view>
          <input :style='{
              "border": "0px solid rgb(255, 170, 51)",
              "padding": "0px 24rpx",
              "margin": "0px",
              "color": "rgb(0, 0, 0)",
              "borderRadius": "8rpx",
              "flex": "1",
              "background": "rgba(255,255,255,.6)",
              "fontSize": "28rpx",
              "height": "76rpx"
            }' v-model="ruleForm.mima" type="password" class="uni-input" name="" placeholder="密码" />
        </view>
        <!-- 确认密码 -->
        <view :style='{
            "margin": "0 0 0px 0",
            "borderColor": "#ff0000",
            "textAlign": "left",
            "borderWidth": "0 0 2rpx",
            "display": "flex",
            "width": "100%",
            "borderStyle": "solid",
            "height": "auto",
            "alignItems": "center"
          }' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
          <view :style='{
              "width": "160rpx",
              "lineHeight": "76rpx",
              "fontSize": "28rpx",
              "color": "#666",
              "textAlign": "right",
              "fontWeight": "500"
            }' class="label">确认密码：</view>
          <input :style='{
              "border": "0px solid rgb(255, 170, 51)",
              "padding": "0px 24rpx",
              "margin": "0px",
              "color": "rgb(0, 0, 0)",
              "borderRadius": "8rpx",
              "flex": "1",
              "background": "rgba(255,255,255,.6)",
              "fontSize": "28rpx",
              "height": "76rpx"
            }' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
        </view>
        <!-- 用户姓名 -->
        <view :style='{
            "margin": "0 0 0px 0",
            "borderColor": "#ff0000",
            "textAlign": "left",
            "borderWidth": "0 0 2rpx",
            "display": "flex",
            "width": "100%",
            "borderStyle": "solid",
            "height": "auto",
            "alignItems": "center"
          }' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
          <view :style='{
              "width": "160rpx",
              "lineHeight": "76rpx",
              "fontSize": "28rpx",
              "color": "#666",
              "textAlign": "right",
              "fontWeight": "500"
            }' class="label">用户姓名：</view>
          <input :style='{
              "border": "0px solid rgb(255, 170, 51)",
              "padding": "0px 24rpx",
              "margin": "0px",
              "color": "rgb(0, 0, 0)",
              "borderRadius": "8rpx",
              "flex": "1",
              "background": "rgba(255,255,255,.6)",
              "fontSize": "28rpx",
              "height": "76rpx"
            }' v-model="ruleForm.yonghuxingming" type="text" class="uni-input" name="" placeholder="用户姓名" />
        </view>
        <!-- 性别 -->
        <view :style='{
            "margin": "0 0 0px 0",
            "borderColor": "#ff0000",
            "textAlign": "left",
            "borderWidth": "0 0 2rpx",
            "display": "flex",
            "width": "100%",
            "borderStyle": "solid",
            "height": "auto",
            "alignItems": "center"
          }' v-if="tableName=='yonghu'" class="">
          <view :style='{
              "width": "160rpx",
              "lineHeight": "76rpx",
              "fontSize": "28rpx",
              "color": "#666",
              "textAlign": "right",
              "fontWeight": "500"
            }' class="label">性别：</view>
          <picker :style='{
              "width": "auto",
              "margin": "0 0 0px 0",
              "lineHeight": "76rpx",
              "textAlign": "left",
              "display": "flex",
              "height": "76rpx"
            }' v-if="tableName=='yonghu'" @change="yonghuxingbieChange" :value="yonghuxingbieIndex"
            :range="yonghuxingbieOptions">
            <view>
              <view :style='{
                "lineHeight": "88rpx",
                "fontSize": "28rpx",
                "color": "#888",
                "textAlign": "left"
              }' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
            </view>
          </picker>
        </view>
        <!-- 年龄 -->
        <view :style='{
            "margin": "0 0 0px 0",
            "borderColor": "#ff0000",
            "textAlign": "left",
            "borderWidth": "0 0 2rpx",
            "display": "flex",
            "width": "100%",
            "borderStyle": "solid",
            "height": "auto",
            "alignItems": "center"
          }' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
          <view :style='{
              "width": "160rpx",
              "lineHeight": "76rpx",
              "fontSize": "28rpx",
              "color": "#666",
              "textAlign": "right",
              "fontWeight": "500"
            }' class="label">年龄：</view>
          <input :style='{
              "border": "0px solid rgb(255, 170, 51)",
              "padding": "0px 24rpx",
              "margin": "0px",
              "color": "rgb(0, 0, 0)",
              "borderRadius": "8rpx",
              "flex": "1",
              "background": "rgba(255,255,255,.6)",
              "fontSize": "28rpx",
              "height": "76rpx"
            }' v-model="ruleForm.nianling" type="text" class="uni-input" name="" placeholder="年龄" />
        </view>
        <!-- 邮箱 -->
        <view :style='{
            "margin": "0 0 0px 0",
            "borderColor": "#ff0000",
            "textAlign": "left",
            "borderWidth": "0 0 2rpx",
            "display": "flex",
            "width": "100%",
            "borderStyle": "solid",
            "height": "auto",
            "alignItems": "center"
          }' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
          <view :style='{
              "width": "160rpx",
              "lineHeight": "76rpx",
              "fontSize": "28rpx",
              "color": "#666",
              "textAlign": "right",
              "fontWeight": "500"
            }' class="label">邮箱：</view>
          <input :style='{
              "border": "0px solid rgb(255, 170, 51)",
              "padding": "0px 24rpx",
              "margin": "0px",
              "color": "rgb(0, 0, 0)",
              "borderRadius": "8rpx",
              "flex": "1",
              "background": "rgba(255,255,255,.6)",
              "fontSize": "28rpx",
              "height": "76rpx"
            }' v-model="ruleForm.youxiang" type="text" class="uni-input" name="" placeholder="邮箱" />
        </view>
        <!-- 手机号 -->
        <view :style='{
            "margin": "0 0 0px 0",
            "borderColor": "#ff0000",
            "textAlign": "left",
            "borderWidth": "0 0 2rpx",
            "display": "flex",
            "width": "100%",
            "borderStyle": "solid",
            "height": "auto",
            "alignItems": "center"
          }' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
          <view :style='{
              "width": "160rpx",
              "lineHeight": "76rpx",
              "fontSize": "28rpx",
              "color": "#666",
              "textAlign": "right",
              "fontWeight": "500"
            }' class="label">手机号：</view>
          <input :style='{
              "border": "0px solid rgb(255, 170, 51)",
              "padding": "0px 24rpx",
              "margin": "0px",
              "color": "rgb(0, 0, 0)",
              "borderRadius": "8rpx",
              "flex": "1",
              "background": "rgba(255,255,255,.6)",
              "fontSize": "28rpx",
              "height": "76rpx"
            }' v-model="ruleForm.shoujihao" type="text" class="uni-input" name="" placeholder="手机号" />
        </view>
        <!-- 头像 -->
        <view :style='{
            "margin": "0 0 0px 0",
            "borderColor": "#ff0000",
            "textAlign": "left",
            "borderWidth": "0 0 2rpx",
            "display": "flex",
            "width": "100%",
            "borderStyle": "solid",
            "height": "auto",
            "alignItems": "center"
          }' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
          <view :style='{
              "width": "160rpx",
              "lineHeight": "76rpx",
              "fontSize": "28rpx",
              "color": "#666",
              "textAlign": "right",
              "fontWeight": "500"
            }' class="label">头像：</view>
          <image :style='{
              "width": "160rpx",
              "borderRadius": "8rpx",
              "objectFit": "cover",
              "display": "block",
              "height": "80rpx"
            }' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
          <image :style='{
              "width": "160rpx",
              "borderRadius": "8rpx",
              "objectFit": "cover",
              "display": "block",
              "height": "80rpx"
            }' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
        </view>
        <!--提交按钮-->
        <button :style='{
            "border": "0",
            "padding": "0px",
            "margin": "48rpx auto 24rpx",
            "color": "rgb(255, 255, 255)",
            "borderRadius": "60rpx",
            "borderColor": "#ff0000",
            "width": "60%",
            "lineHeight": "88rpx",
            "fontSize": "36rpx",
            "height": "88rpx"
          }' class="btn-submit" @tap="register" type="warn">注册</button>
      </view>
    </view>
  </view>
</template>

<script>
  import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
  export default {
    data() {
      return {
        yonghuxingbieOptions: [],
        yonghuxingbieIndex: 0,
        ruleForm: {
          yonghuzhanghao: '',
          mima: '',
          yonghuxingming: '',
          xingbie: '',
          nianling: '',
          youxiang: '',
          shoujihao: '',
          touxiang: '',
          openid: '',
          nickname: '',
          avatarurl: '',
        },
        tableName: ""
      }
    },
    components: {
      multipleSelect
    },
    computed: {
      baseUrl() {
        return this.$base.url;
      },
    },
    async onLoad() {
      let res = [];
      let table = uni.getStorageSync("loginTable");
      this.tableName = table;

      if (this.tableName == 'yonghu') {
        this.yonghuxingbieOptions = "男,女".split(',');
        this.ruleForm.xingbie = this.yonghuxingbieOptions[0]
      }

      this.styleChange()
    },
    methods: {
      yonghuxingbieChange(e) {
        this.yonghuxingbieIndex = e.target.value
        this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
      },
      yonghutouxiangTap() {
        let _this = this;
        this.$api.upload(function(res) {
          _this.ruleForm.touxiang = 'upload/' + res.file;
          _this.$forceUpdate();
        });
      },
      toggleTab(str) {
        this.$refs[str].show();
      },

      styleChange() {
        this.$nextTick(() => {
          // document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
          //   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
          // })
        })
      },
      getUUID() {
        return new Date().getTime();
      },
      async register() {
        if ((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName) {
          this.$utils.msg(`用户账号不能为空`);
          return
        }
        if ((!this.ruleForm.mima) && `yonghu` == this.tableName) {
          this.$utils.msg(`密码不能为空`);
          return
        }
        if (`yonghu` == this.tableName && (this.ruleForm.mima != this.ruleForm.mima2)) {
          this.$utils.msg(`两次密码输入不一致`);
          return
        }
        if ((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName) {
          this.$utils.msg(`用户姓名不能为空`);
          return
        }
        if (`yonghu` == this.tableName && this.ruleForm.youxiang && (!this.$validate.isEmail(this.ruleForm
            .youxiang))) {
          this.$utils.msg(`邮箱应输入邮件格式`);
          return
        }
        if (`yonghu` == this.tableName && this.ruleForm.shoujihao && (!this.$validate.isMobile(this.ruleForm
            .shoujihao))) {
          this.$utils.msg(`手机号应输入手机格式`);
          return
        }
        await this.$api.register(`${this.tableName}`, this.ruleForm);
        this.$utils.msgBack('注册成功');;
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