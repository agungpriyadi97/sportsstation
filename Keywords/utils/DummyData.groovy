package utils

import com.kms.katalon.core.annotation.Keyword
import java.util.Random

class DummyData {

    private static final Random RANDOM = new Random()

    //---------------------------------------------------
    // MASTER DATA
    //---------------------------------------------------

    private static final List<Map> USERS = [

        [first:"Agung", last:"Priyadi"],
        [first:"Andi", last:"Suswanto"],
        [first:"Budi", last:"Santoso"],
        [first:"Dimas", last:"Saputra"],
        [first:"Eko", last:"Setiawan"],
        [first:"Fajar", last:"Maulana"],
        [first:"Indra", last:"Wijaya"],
        [first:"Rian", last:"Permana"],
        [first:"Rizky", last:"Pratama"],
        [first:"Yoga", last:"Kurniawan"]

    ]

    private static final List<String> STREETS = [

        "Jl. Nangka",
        "Jl. Melati",
        "Jl. Mawar",
        "Jl. Kenanga",
        "Jl. Anggrek",
        "Jl. Merpati",
        "Jl. Kutilang",
        "Jl. Cendrawasih",
        "Jl. Pahlawan",
        "Jl. Sudirman",
        "Jl. Diponegoro",
        "Jl. Gatot Subroto",
        "Jl. Ahmad Yani",
        "Jl. Pemuda",
        "Jl. Veteran"

    ]

    //---------------------------------------------------
    // REGISTRATION
    //---------------------------------------------------

    @Keyword
    Map generateRegistrationData() {

        Map user = USERS[RANDOM.nextInt(USERS.size())]

        int randomNumber = 10000 + RANDOM.nextInt(90000)

        String inbox =
                (user.first + user.last + randomNumber)
                        .toLowerCase()

        String email = inbox + "@mailinator.com"

        return [

            inbox       : inbox,
            email       : email,
            password    : "Laskar123456",

            firstName   : user.first,
            lastName    : user.last,
            fullName    : user.first + " " + user.last,

            mobilePhone : generateMobilePhone()

        ]
    }

    //---------------------------------------------------
    // SHIPPING / BILLING ADDRESS
    //---------------------------------------------------

    @Keyword
    Map generateAddressData() {

        Map user = USERS[RANDOM.nextInt(USERS.size())]

        String address =
                STREETS[RANDOM.nextInt(STREETS.size())] +
                " No." + (1 + RANDOM.nextInt(250)) +
                ", RT " + (1 + RANDOM.nextInt(9)).toString().padLeft(2,'0') +
                "/RW " + (1 + RANDOM.nextInt(9)).toString().padLeft(2,'0')

        return [

            firstName : user.first,

            lastName  : user.last,

            phone     : generateMobilePhone(),

            address   : address,

            province  : "Banten",

            city      : "Kab. Lebak",

            district  : "Banjarsari"

        ]
    }

    //---------------------------------------------------
    // PHONE
    //---------------------------------------------------

    private String generateMobilePhone() {

        StringBuilder phone = new StringBuilder("857")

        for(int i=0;i<8;i++) {

            phone.append(RANDOM.nextInt(10))

        }

        return phone.toString()

    }

}