<div class="panel panel-primary">
    <div class="panel-heading">
        <h4 class="panel-title">Calendrier</h4>
    </div>
    <div id='calendar'></div>
</div>

<script type="text/javascript">

    $(function () {
        $('#calendar').fullCalendar({
            lang: 'fr',
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,basicWeek,basicDay'
            },
            eventLimit: true, // allow "more" link when too many events
            events: [
                {
                    title: 'Formation 1 day',
                    start: '2014-10-01'
                },
                {
                    title: 'Formation several days',
                    start: '2014-10-07',
                    end: '2014-10-10'
                },
                {
                    id: 999,
                    title: 'Repeating Event',
                    start: '2014-09-09T16:00:00'
                },
                {
                    id: 999,
                    title: 'Repeating Event',
                    start: '2014-09-16T16:00:00'
                },
                {
                    title: 'Formation SAP RH',
                    start: '2014-09-11',
                    end: '2014-09-13'
                },
                {
                    title: 'Meeting',
                    start: '2014-09-12T10:30:00',
                    end: '2014-09-12T12:30:00'
                },
                {
                    title: 'Lunch',
                    start: '2014-09-12T12:00:00'
                },
                {
                    title: 'Meeting',
                    start: '2014-09-12T14:30:00'
                },
                {
                    title: 'Happy Hour',
                    start: '2014-09-12T17:30:00'
                },
                {
                    title: 'Dinner',
                    start: '2014-09-12T20:00:00'
                },
                {
                    title: 'Event with link',
                    url: 'http://google.com/',
                    start: '2014-09-28'
                }
            ]
        });
    });
</script>
