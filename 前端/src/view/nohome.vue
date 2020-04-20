<template>
    <div class="login">
        <transition>
          <router-view></router-view>
        </transition>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="scss" scoped>
*{
        margin: 0;
        padding: 0;
        font-size: 20px;
        font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
.login{
    overflow: hidden;
    line-height: 50px;
     position:absolute;
    top:0;
    bottom:0;
    left:0;
    right: 0;
    background-image: url("../image/loginphoto.jpg");
    background-size: 100%;
    opacity: 0.6;   
   
    }
.v-enter,.v-leave-to{
  opacity: 0;
  transform: translateY(100%);
  
}
.v-enter-active{
transition: all 1s ease;
transition-delay: 1s;
}
.v-leave-active{
  transition: all 1s ease;

}

</style>