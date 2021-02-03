// eslint-disable-next-line no-undef
define(["require", "exports"], function (require, exports) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    exports.scheduleData = [
        {
            Id: 1,
            Subject: 'Explosion of Betelgeuse Star',
            StartTime: new Date(2018, 1, 11, 9, 30),
            EndTime: new Date(2018, 1, 11, 11, 0),
            CategoryColor: '#1aaa55'
        }, {
            Id: 2,
            Subject: 'Thule Air Crash Report',
            StartTime: new Date(2018, 1, 12, 12, 0),
            EndTime: new Date(2018, 1, 12, 14, 0),
            CategoryColor: '#357cd2'
        }, {
            Id: 3,
            Subject: 'Blue Moon Eclipse',
            StartTime: new Date(2018, 1, 13, 9, 30),
            EndTime: new Date(2018, 1, 13, 11, 0),
            CategoryColor: '#7fa900'
        }, {
            Id: 4,
            Subject: 'Meteor Showers in 2018',
            StartTime: new Date(2018, 1, 14, 13, 0),
            EndTime: new Date(2018, 1, 14, 14, 30),
            CategoryColor: '#ea7a57'
        }
    ];

    exports.roomData = [
        {
            Id: 1,
            Subject: 'Board Meeting',
            Description: 'Meeting to discuss business goal of 2018.',
            StartTime: new Date(2018, 6, 30, 9, 0),
            EndTime: new Date(2018, 6, 30, 11, 0),
            RoomId: 1
        },
        {
            Id: 2,
            Subject: 'Training session on JSP',
            Description: 'Knowledge sharing on JSP topics.',
            StartTime: new Date(2018, 6, 30, 15, 0),
            EndTime: new Date(2018, 6, 30, 17, 0),
            RoomId: 5
        },
        {
            Id: 3,
            Subject: 'Sprint Planning with Team members',
            Description: 'Planning tasks for sprint.',
            StartTime: new Date(2018, 6, 30, 9, 30),
            EndTime: new Date(2018, 6, 30, 11, 0),
            RoomId: 3
        },
        {
            Id: 4,
            Subject: 'Meeting with Client',
            Description: 'Customer meeting to discuss features.',
            StartTime: new Date(2018, 6, 30, 11, 0),
            EndTime: new Date(2018, 6, 30, 13, 0),
            RoomId: 4
        }
    ];
});