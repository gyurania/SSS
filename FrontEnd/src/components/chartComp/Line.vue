<template>
    <div>
        <LineChartGenerator
            :chart-options="chartOptions"
            :chart-data="chartData"
            :chart-id="chartId"
            :dataset-id-key="datasetIdKey"
            :plugins="plugins"
            :css-classes="cssClasses"
            :styles="styles"
            :width="width"
            :height="height"
        />
    </div>
</template>

<script>
import { Line as LineChartGenerator } from 'vue-chartjs/legacy'
import axios from 'axios'
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  LineElement,
  LinearScale,
  CategoryScale,
  PointElement
} from 'chart.js'

ChartJS.register(
  Title,
  Tooltip,
  Legend,
  LineElement,
  LinearScale,
  CategoryScale,
  PointElement
)

export default {
  name: 'LineChart',

  mounted () {
    this.getData()
  },
  components: {
    LineChartGenerator
  },
  props: {
    childId: String,
    chartId: {
      type: String,
      default: 'line-chart'
    },
    datasetIdKey: {
      type: String,
      default: 'label'
    },
    width: {
      type: Number,
      default: 400
    },
    height: {
      type: Number,
      default: 400
    },
    cssClasses: {
      default: '',
      type: String
    },
    styles: {
      type: Object,
      default: () => {}
    },
    plugins: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      chartData: {
        labels: [

        ],
        datasets: [
          {
            label: '점수',
            backgroundColor: 'red',
            data: [],
            borderColor: 'red'
          },
          {
            label: '놀이 시간',
            backgroundColor: 'blue',
            data: [],
            borderColor: 'blue'
          }
        ]
      },
      chartOptions: {
        responsive: true,
        maintainAspectRatio: false
      },
      getData () {
        axios.get(`https://i7a606.q.ssafy.io/service-api/play/list/${this.childId}`)
        .then(res => {
          console.log(res.data);
            this.chartData = {
                labels: [

                ],
                datasets: [
                {
                    label: '점수',
                    backgroundColor: 'red',
                    data: [],
                    borderColor: 'red'
                },
                {
                    label: '놀이 시간',
                    backgroundColor: 'blue',
                    data: [],
                    borderColor: 'blue'
                }
                ]
            }

            for (let data of res.data) {
                this.chartData.labels.push(`${data.playTime.slice(0, 10)} ${data.playTime.slice(11, 19)}`)
                this.chartData.datasets[0].data.push(data.score)
                this.chartData.datasets[1].data.push(parseInt(data.totalTime.slice(0, 2))*3600 + parseInt(data.totalTime.slice(3, 5))*60 + parseInt(data.totalTime.slice(6)))
            }

            let tempTimes = []

            for (let time of this.chartData.datasets[1].data) {
                console.log(time);
                tempTimes.push(time * Math.max(...this.chartData.datasets[0].data) / Math.max(...this.chartData.datasets[1].data))

            }
            this.chartData.datasets[1].data = tempTimes

        })        
      }
    }
  }
}
</script>
