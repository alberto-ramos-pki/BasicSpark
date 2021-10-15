import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
val stats = new DescriptiveStatistics()

val array_test = Array(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
array_test.foreach(stats.addValue(_))

println(stats.getPercentile(90))