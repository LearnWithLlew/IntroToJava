Sub SplitSlides()
    For i = 35 To 34 Step -1
        SplitSingleSlide (i)
    Next i
End Sub

Sub SplitSingleSlide(slideNumber)
    Set current = Application.ActivePresentation.Slides(slideNumber)
    Set newSlide = current.Duplicate
    DeleteCode current
    SlideTimings 5, current
    SlideTimings 1, newSlide
End Sub
Public Sub SlideTimings(time, forSlide)
  forSlide.SlideShowTransition.AdvanceOnTime = msoTrue
  forSlide.SlideShowTransition.AdvanceTime = time
End Sub
Public Sub DeleteCode(slide)
    Dim txt As String
    For Each pptShape In slide.Shapes
        If pptShape.Type <> msoTextBox Then
             pptShape.Delete
        End If
    Next
End Sub

••••ˇˇˇˇ
