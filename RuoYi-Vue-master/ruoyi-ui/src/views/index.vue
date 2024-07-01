  <template>
        <el-card id="Billy">
      <el-row>
        <el-col :span="6">
          <div id="line" style="width: 80%;height:400%"></div>
        </el-col>
        <el-col :span="12">
          <div id="map" style="width: auto;height:400%"></div>
        </el-col>
        <el-col :span="6">
          <div id="pie" style="width: 80%;height:400%"></div>
        </el-col>
      </el-row>
    </el-card>
      </template>
  <script>
  import 'echarts/lib/chart/map'
  import 'echarts/map/js/china'
  import { countByProvince,countBySalary} from "@/api/analysis/analysis";

  require('echarts/theme/blue')
  require('echarts/lib/component/graphic');
  export default {
    data(){
      return {
        mapOptions :{
          //标题样式
          title: {
            text: '就业情况图',
            x: "center",
            y: '0%',
            textStyle: {
              fontSize: 20,
              color: "blue"
            },
          },
          //这里设置提示框 (鼠标悬浮效果)
          tooltip: {
            //数据项图形触发
            trigger: 'item',
            //提示框浮层的背景颜色。 (鼠标悬浮后的提示框背景颜色)
            backgroundColor: "blue",
            //字符串模板(地图): {a}（系列名称），{b}（区域名称），{c}（合并数值）,{d}（无）
            // formatter: '地区：{b}<br/>就业人数：{c}',

            formatter: function (params) {
              let value = params.value;
              // console.info(typeof value);
              // console.info(value);
              if (isNaN(value)) { // 数据不存在时显示为0
                value = 0;
              }
              return params.name + ': ' + value + '人';
            }
          },
          //视觉映射组件
          visualMap: {
            top: 'center',
            left: 'left',
            // 数据的范围
            min: 0,
            max: 800,
            text: ['高', '低'],
            realtime: true, //拖拽时，是否实时更新
            calculable: true, //是否显示拖拽用的手柄

          },
          series: [{
            name: '就业',
            type: 'map',
            mapType: 'china',
            roam: true,
            //是否开启鼠标缩放和平移漫游
            itemStyle: {
              //地图区域的多边形 图形样式
              normal: {
                //是图形在默认状态下的样式
                label: {
                  show: true, //是否显示标签
                  textStyle: {
                    color: "blue"
                  }
                }
              },
              zoom: 1,
              //地图缩放比例,默认为1
              emphasis: {
                //是图形在高亮状态下的样式,比如在鼠标悬浮或者图例联动高亮时
                label: {
                  show: true
                }
              }
            },
            top: '0%',
            left: '15%',
            data: []
          }]
        },
        PieOption:{
          title: {
            text: '不同薪资就业人数',
            left: 'center'
          },
          tooltip: {
            trigger: 'item'
          },
          legend: {
            orient: 'vertical',
            left: 'right'
          },
          series: [
            {
              name: 'Access From',
              type: 'pie',
              radius: '50%',
              data: [
                { value: 1048, name: 'Search Engine' },
                { value: 735, name: 'Direct' },
                { value: 580, name: 'Email' },
                { value: 484, name: 'Union Ads' },
                { value: 300, name: 'Video Ads' }
              ],
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
        },
      }
    },
    mounted() {
      this.showPie()
      this.showMap()
      this.getcountProvince()
      this.getcountSalary()
    },
    methods:{
      getcountSalary(){
        countBySalary().then(response =>{
          this.PieOption.series[0].data = response.data
          this.showPie()
        })
      },
      getcountProvince(){
        countByProvince().then(response =>{
          this.mapOptions.series[0].data = response.data
          this.showMap()
        })
      },
      showPie(){
        let pieEcharts = this.$echarts.init(document.getElementById('pie'),'blue')
        pieEcharts.setOption(this.PieOption)
      },
      showMap(){
        let MapEcharts = this.$echarts.init(document.getElementById('map'),'blue')
        MapEcharts.setOption(this.mapOptions)
      }
    }
  }
  </script>
  <style>
  body {
    background-color: #f0f2f5; /* 您想要的颜色代码 */
  }
  #Billy {
    background-color: #f0f2f5; /* 您想要的颜色代码 */
  }
  </style>
