package com.kafkareplay.config.kafka

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer

@EnableKafka
@Configuration
class KafkaProducerConfig(
  @Value("\${spring.kafka.bootstrap-servers}") server: String
) {

  val producerProps = mapOf(
    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to server,
    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
  )

  @Bean
  fun producerFactory(): ProducerFactory<String, Any> {
    return DefaultKafkaProducerFactory(producerProps)
  }


  @Bean
  fun kafkaTemplate(): KafkaTemplate<String, Any> {
    val kafkaTemplate = KafkaTemplate(producerFactory())
    kafkaTemplate.setObservationEnabled(true)
    return kafkaTemplate
  }
}