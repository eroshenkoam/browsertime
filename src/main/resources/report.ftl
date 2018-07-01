<#-- @ftlvariable name="browsertime" type="io.eroshenkoam.browsertime.browsertime.BrowsertimeReport" -->
<#-- @ftlvariable name="coach" type="io.eroshenkoam.browsertime.coach.CoachReport" -->

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <h1>Report</h1>
            <p class="lead">${browsertime.info.url}</p>
            <h2>Coach</h2>
            <div class="row">
                <@card name="Overal Score" value=coach.advice.score />
                <@card name="Performance Score" value=coach.advice.performance.score />
                <@card name="Accessability Score" value=coach.advice.accessibility.score />
                <@card name="Best Practice Score" value=coach.advice.bestpractice.score />

                <@card name="Total Requests" value=coach.advice.info.pageRequests />
                <@card name="Css Requests" value=coach.advice.info.pageContentTypes.css.requests />
                <@card name="Images Requests" value=coach.advice.info.pageContentTypes.image.requests />
                <@card name="Javascript Requests" value=coach.advice.info.pageContentTypes.javascript.requests />

                <@card name="Total Content Size" value=coach.advice.info.pageContentSize />
                <@card name="Css Content Size" value=coach.advice.info.pageContentTypes.css.contentSize />
                <@card name="Images Content Size" value=coach.advice.info.pageContentTypes.image.contentSize />
                <@card name="Javascript Content Size" value=coach.advice.info.pageContentTypes.javascript.contentSize />

                <@card name="Total Transfer Requests" value=coach.advice.info.pageTransferSize />
                <@card name="Css Transfer Requests" value=coach.advice.info.pageContentTypes.css.transferSize />
                <@card name="Images Transfer Requests" value=coach.advice.info.pageContentTypes.image.transferSize />
                <@card name="Javascript Transfer Requests" value=coach.advice.info.pageContentTypes.javascript.transferSize />
            </div>

            <h2>Browsertime</h2>
            <div class="row">
                <div class="col">
                    <table class="table table-striped table-bordered table-dark">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">median
                            </td>
                            <th scope="col">min
                            </td>
                            <th scope="col">p10
                            </td>
                            <th scope="col">p90
                            </td>
                            <th scope="col">p99
                            </td>
                            <th scope="col">max
                            </td>
                        </tr>
                        </thead>
                        <tbody>
                    <@rowGroup name="Page Timings"/>
                    <@rowStatistic name="Backend Time" data=browsertime.statistics.timings.pageTimings.backEndTime/>
                    <@rowStatistic name="Frontent Time" data=browsertime.statistics.timings.pageTimings.frontEndTime/>
                    <@rowStatistic name="Page Load Time" data=browsertime.statistics.timings.pageTimings.pageLoadTime/>
                    <@rowStatistic name="Domain Lookup Time" data=browsertime.statistics.timings.pageTimings.domainLookupTime/>
                    <@rowStatistic name="Page Load Time" data=browsertime.statistics.timings.pageTimings.pageDownloadTime/>
                    <@rowStatistic name="Server Conntenction Time" data=browsertime.statistics.timings.pageTimings.serverConnectionTime/>
                    <@rowStatistic name="Server Response Time" data=browsertime.statistics.timings.pageTimings.serverResponseTime/>
                    <@rowStatistic name="DOM Content Loaded Time" data=browsertime.statistics.timings.pageTimings.domContentLoadedTime/>
                    <@rowStatistic name="DOM Interactive Time" data=browsertime.statistics.timings.pageTimings.domInteractiveTime/>

                    <@rowGroup name="Timings"/>
                    <@rowStatistic name="RUM Speed Index" data=browsertime.statistics.timings.rumSpeedIndex />
                    <@rowStatistic name="First Paint" data=browsertime.statistics.timings.firstPaint />
                    <@rowStatistic name="Fully Load" data=browsertime.statistics.timings.fullyLoaded />

                    <@rowGroup name="Visual Metrics"/>
                    <@rowStatistic name="Speed Index" data=browsertime.statistics.visualMetrics.speedIndex />
                    <@rowStatistic name="Perceptual Speed Index" data=browsertime.statistics.visualMetrics.perceptualSpeedIndex />
                    <@rowStatistic name="First Visual Change" data=browsertime.statistics.visualMetrics.firstVisualChange />
                    <@rowStatistic name="Last Visual Change" data=browsertime.statistics.visualMetrics.lastVisualChange />
                    <@rowStatistic name="Visual Readiness" data=browsertime.statistics.visualMetrics.visualReadiness />
                    <@rowStatistic name="Visual Complete 85" data=browsertime.statistics.visualMetrics.visualComplete85 />
                    <@rowStatistic name="Visual Complete 95" data=browsertime.statistics.visualMetrics.visualComplete95 />
                    <@rowStatistic name="Visual Complete 99" data=browsertime.statistics.visualMetrics.visualComplete99 />

                    <@rowGroup name="Visual Timing"/>
                    <@rowStatistic name="Worker Start" data=browsertime.statistics.timings.navigationTiming.workerStart />
                    <@rowStatistic name="Load Event Start" data=browsertime.statistics.timings.navigationTiming.loadEventStart />
                    <@rowStatistic name="Load Event End" data=browsertime.statistics.timings.navigationTiming.loadEventEnd />
                    <@rowStatistic name="DOM Interactive" data=browsertime.statistics.timings.navigationTiming.domInteractive />
                    <@rowStatistic name="DOM Content Loaded Event Start" data=browsertime.statistics.timings.navigationTiming.domContentLoadedEventStart />

                    <@rowGroup name="Page Info"/>
                    <@rowStatistic name="Document Width" data=browsertime.statistics.pageinfo.documentWidth />
                    <@rowStatistic name="Document Height" data=browsertime.statistics.pageinfo.documentHeight />
                    <@rowStatistic name="Document Transfer Size" data=browsertime.statistics.pageinfo.documentSize.transferSize/>
                    <@rowStatistic name="Document Transfer Size" data=browsertime.statistics.pageinfo.documentSize.transferSize/>
                    <@rowStatistic name="Document Decoded Body Size" data=browsertime.statistics.pageinfo.documentSize.decodedBodySize/>
                    <@rowStatistic name="Document Encoded Body Size" data=browsertime.statistics.pageinfo.documentSize.encodedBodySize/>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<#macro card name value>
<div class="col-3">
    <div class="card" style="margin-bottom: 20px; height: 120px;">
        <div class="card-body">
            <h5 class="card-title">${name}</h5>
            <p class="card-text">${value}</p>
        </div>
    </div>
</div>
</#macro>

<#macro rowGroup name>
    <td scope="row" colspan="7">${name}</td>
</#macro>

<#macro rowStatistic name data>
<tr>
    <td scope="row">${name}</td>
    <td>${data.median}</td>
    <td>${data.min}</td>
    <td>${data.p10}</td>
    <td>${data.p90}</td>
    <td>${data.p99}</td>
    <td>${data.max}</td>
</tr>
</#macro>
