package org.jeong.reservationinformation.reservation.culture.domian.enums

enum class CultureCategory {
    ALL {
        override fun getCultureCategoryKoreanName(): String {
            return ""
        }
    },

    COMPETITION {
        override fun getCultureCategoryKoreanName(): String {
            return "대회"
        }
    },

    EXHIBITION {
        override fun getCultureCategoryKoreanName(): String {
            return "전시"
        }
    },

    PREVIEW {
        override fun getCultureCategoryKoreanName(): String {
            return "관람"
       }
    },

    PERFORMANCE {
        override fun getCultureCategoryKoreanName(): String {
            return "공연"
        }
    },

    CONCERT {
        override fun getCultureCategoryKoreanName(): String {
            return "콘서트"
        }
    };

    abstract fun getCultureCategoryKoreanName(): String
}