package org.jeong.reservationinformation.reservation.enum

enum class SportCategory {
    ALL {
        override fun getSportCategoryKoreanName(): String {
            return ""
        }
    },
    SOCCER_STADIUM {
        override fun getSportCategoryKoreanName(): String {
            return "축구장"
        }
    },
    FUTSAL_STADIUM {
        override fun getSportCategoryKoreanName(): String {
            return "풋살경기장"
        }
    },
    TENNIS_COURT {
        override fun getSportCategoryKoreanName(): String {
            return "테니스장"
        }
    },
    FOOTBALL_COURT {
        override fun getSportCategoryKoreanName(): String {
            return "족구장"
        }
    },
    BASEBALL_COURT {
        override fun getSportCategoryKoreanName(): String {
            return "야구장"
        }
    },
    BASKETBALL_COURT {
        override fun getSportCategoryKoreanName(): String {
            return "농구장"
        }
    },
    MULTIPURPOSE_STADIUM {
        override fun getSportCategoryKoreanName(): String {
            return "다목적경기장"
        }
    },
    VOLLEYBALL_COURT {
        override fun getSportCategoryKoreanName(): String {
            return "배구장"
        }
    },
    BADMINTON_COURT {
        override fun getSportCategoryKoreanName(): String {
            return "배드민턴장"
        }
    },
    FUTSAL {
        override fun getSportCategoryKoreanName(): String {
            return "풋살장"
        }
    },
    PLAYGROUND {
        override fun getSportCategoryKoreanName(): String {
            return "운동장"
        }
    },
    GYM {
        override fun getSportCategoryKoreanName(): String {
            return "체육관"
        }
    },
    TABLE_TENNIS_COURT {
        override fun getSportCategoryKoreanName(): String {
            return "탁구장"
        }
    },
    PARK_GOLF_COURSE {
        override fun getSportCategoryKoreanName(): String {
            return "파크골프장"
        }
    };

    abstract fun getSportCategoryKoreanName(): String
}